package me.chardskarth.sqlbuilder

import me.chardskarth.sqlbuilder.dsl.and
import me.chardskarth.sqlbuilder.dsl.eq
import me.chardskarth.sqlbuilder.dsl.greater
import me.chardskarth.sqlbuilder.dsl.less
import me.chardskarth.sqlbuilder.dsl.like
import me.chardskarth.sqlbuilder.dsl.notInList
import me.chardskarth.sqlbuilder.dsl.or
import me.chardskarth.sqlbuilder.exception.FromTableNotSpecifiedException
import me.chardskarth.sqlbuilder.sqloperators.sub
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.text.RegexOption.MULTILINE

internal class QueryBuilderTest {
    @Test
    fun shouldMatchSqlWithSelectStar() {
        var sql = QueryBuilder {
            fields("*")
            from("tablename")
        }.sql
        assertEquals("SELECT * FROM tablename", sql)

        sql = QueryBuilder()
            .fields("*")
            .from("tablename")
            .sql
        assertEquals("SELECT * FROM tablename", sql)
    }
    @Test
    fun shouldThrowWhenTableNotSpecified() {
        val sql = QueryBuilder {
            fields("id", "name")
            limit(10)
        }
        assertFailsWith<FromTableNotSpecifiedException> {
            sql.sql
        }
    }

    @Test
    fun shouldMatchSqlWithMultipleFields() {
       val sql = QueryBuilder {
            fields("id", "name")
            from("tablename")
        }.sql
        assertEquals("SELECT id, name FROM tablename", sql)
    }

    @Test
    fun shouldMatchSqlWithLimitAndOffset() {
        val sql = QueryBuilder {
            fields("id", "name")
            from("tablename")
            limit(10)
        }
        assertEquals("SELECT id, name FROM tablename LIMIT 10", sql.sql)
        sql.limit(2, 3)
        assertEquals("SELECT id, name FROM tablename LIMIT 2 OFFSET 3", sql.sql)
    }

    @Test
    fun shouldMatchSqlWithSpecifiedOrderBy() {
        val sql = QueryBuilder {
            fields("id", "name")
            from("tablename")
        }
        sql.orderAsc("created_date")
        assertEquals("SELECT id, name FROM tablename ORDER BY created_date ASC", sql.sql)
        sql.orderDesc("modified_date")
        assertEquals("SELECT id, name FROM tablename ORDER BY created_date ASC, modified_date DESC", sql.sql)
        sql.limit(2, 3)
        assertEquals("SELECT id, name FROM tablename ORDER BY created_date ASC, modified_date DESC LIMIT 2 OFFSET 3", sql.sql)
    }

    @Test
    fun shouldMatchSqlWithWhereClause() {
        val sql = QueryBuilder {
            fields("id", "name")
            from("tablename")
            where("name = 'some name'")
        }
        assertEquals("SELECT id, name FROM tablename WHERE name = 'some name'", sql.sql)
    }

    internal class SubQueriesAndUnions {
        @Test
        fun shouldMatchSqlWithSubQuery() {
            val sql = QueryBuilder {
                fields("id", "name", "age")
                from {
                    fields("*")
                    from("user")
                    where("age" less 50)
                    limit(10, 0)
                }
                where("name" like "Bat Man")
            }
            assertEquals("SELECT id, name, age FROM (SELECT * FROM user WHERE age < 50 LIMIT 10 OFFSET 0) WHERE name LIKE ?", sql.sql)
        }

        @Test
        fun shouldMatchSqlWithLeftJoin() {
            val sql = QueryBuilder {
                fields("*")
                from("user")
                leftJoin("address", "user_id = user.id")
            }
            assertEquals("SELECT * FROM user LEFT JOIN address ON ( user_id = user.id )", sql.sql)
        }
        @Test
        fun shouldMatchSqlWithMultipleJoin() {
            val sql = QueryBuilder {
                fields(
                    "user.id as `user-id`",
                    "role.id as `role-id`",
                    "address.id as `address-id`",
                )
                from("user")
                leftJoin("address", "address.user_id = user.id")
                leftJoin("user_has_role AS uhr", "uhr.user_id = user.id")
                leftJoin("role", "role_user_id = user.id")
                where(
                    "user.status" greater 0 or ("user.id" notInList arrayOf(1, 2, 3))
                    )
                 orderAsc("user.id")
            }
            assertEquals("""
                |SELECT user.id as `user-id`,
                |role.id as `role-id`, address.id as `address-id`
                |FROM user LEFT JOIN address ON ( address.user_id = user.id )
                |LEFT JOIN user_has_role AS uhr ON ( uhr.user_id = user.id )
                |LEFT JOIN role ON ( role_user_id = user.id )
                |WHERE user.status > 0 OR user.id NOT IN (1,2,3) ORDER BY user.id ASC
            """.replace(Regex("\\s*\\|", MULTILINE), " ").trim()
                , sql.sql)
        }
    }


    internal class DslOperators {
        @Test
        fun shouldMatchSqlWithWhereClauseAsQueryBlock() {
            val sql = QueryBuilder {
                fields("id", "name")
                from("tablename")
                where("name" eq "someValue")
            }
            assertEquals("SELECT id, name FROM tablename WHERE name = ?", sql.sql)
        }
        @Test
        fun shouldMatchSqlWithMultipleWhereClause() {
            val sql = QueryBuilder {
                fields("id", "name", "age")
                from("user")
                where(
                    "name" eq "Bat Man" and
                            ("id" greater 1) and
                            sub(("name" like "%bat") or ("name" like "man%"))

                )
            }
            assertEquals("SELECT id, name, age FROM user WHERE name = ? AND id > 1 AND ( name LIKE ? OR name LIKE ? )", sql.sql)
        }
    }

}

