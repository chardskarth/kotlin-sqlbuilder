package io.github.chardskarth.sqlbuilder

import io.github.chardskarth.sqlbuilder.QueryPart.LimitQueryPart
import io.github.chardskarth.sqlbuilder.QueryPart.SelectQueryPart
import io.github.chardskarth.sqlbuilder.QueryPart.WhereQueryPart
import io.github.chardskarth.sqlbuilder.dsl.eq
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals

class QueryBuilderWithCustomExpressionTest {
    private val baseSql = QueryBuilder {
        fields("id", "last_name")
        from("user")
        where("name" eq "Leng")
    }
    @Test
    fun shouldMatchWithAddingCustomExpressionsForSelect() {
        fun QueryBuilder.distinct(): QueryBuilder {
            addQueryExpression(SelectQueryPart {
                QueryBlock("DISTINCT")
            })
            return this
        }
        val sql = baseSql.copy().distinct()
        assertEquals("SELECT DISTINCT id, last_name FROM user WHERE name = ?", sql.sql)
    }
    @Test
    fun shouldMatchWithAddingCustomExpressionsForLimit() {
        fun QueryBuilder.forUpdate(): QueryBuilder {
            addQueryExpression(LimitQueryPart {
                QueryBlock("FOR UPDATE")
            })
            return this
        }
        val sql = baseSql.copy().forUpdate()
        assertEquals("SELECT id, last_name FROM user WHERE name = ? FOR UPDATE", sql.sql)
    }
    @Test
    fun shouldMatchWithAddingCustomExpressionsForWhere() {
        fun QueryBuilder.distinct(): QueryBuilder {
            addQueryExpression(SelectQueryPart {
                QueryBlock("DISTINCT")
            })
            return this
        }
        fun QueryBuilder.union(queryBuilderBlock: QueryBuilder.() -> Unit) {
            val queryBuilder = QueryBuilder(queryBuilderBlock)
            addQueryExpression(WhereQueryPart {
                QueryBlock("UNION (", queryBuilder.sql, ")")
            })
        }
        fun QueryBuilder.unionAll(queryBuilderBlock: QueryBuilder.() -> Unit) {
            val queryBuilder = QueryBuilder(queryBuilderBlock)
            addQueryExpression(WhereQueryPart {
                QueryBlock("UNION ALL (", queryBuilder.sql, ")")
            })
        }

        val sql = baseSql.copyWith {
            union {
                distinct()
                fields("id", "first_name")
                from("customer")
            }
            unionAll {
                fields("id", "first_name")
                from("customer_blacklist")
                where("status" eq 1)
            }
            orderAsc("user.id")
        }
        assertEquals("SELECT id, last_name FROM user WHERE name = ? " +
                "UNION ( SELECT DISTINCT id, first_name FROM customer ) " +
                "UNION ALL ( SELECT id, first_name FROM customer_blacklist " +
                "WHERE status = 1 ) ORDER BY user.id ASC", sql.sql)
    }
}