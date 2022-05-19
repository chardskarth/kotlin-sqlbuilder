package io.github.chardskarth.sqlbuilder

import io.github.chardskarth.sqlbuilder.QueryPart.LimitQueryPart
import io.github.chardskarth.sqlbuilder.QueryPart.SelectQueryPart
import io.github.chardskarth.sqlbuilder.QueryPart.WhereQueryPart
import io.github.chardskarth.sqlbuilder.exception.FromTableNotSpecifiedException
import io.github.chardskarth.sqlbuilder.extension.letOrEmptyString
import kotlin.text.RegexOption.MULTILINE

data class QueryBuilder(
    private val fields:MutableList<String> = mutableListOf(),
    private var tableFrom: String? = null,
    private var limit: Int? = null,
    private var offset: Int? = null,
    private var orderBy: MutableList<Pair<String, String>> = mutableListOf(),
    private var whereClause: MutableList<QueryBlock> = mutableListOf(),
    private var tableJoins: MutableMap<String, QueryBlock> = mutableMapOf(),
    private var customQueryParts:MutableList<QueryPart> = mutableListOf(),
) {

    constructor(queryBuilderBlock: QueryBuilder.() -> Unit): this() {
        this.queryBuilderBlock()
    }

    fun fields(vararg fieldsParam: String): QueryBuilder {
        fields.addAll(fieldsParam)
        return this
    }
    fun from(tableName: String): QueryBuilder {
        tableFrom = tableName
       return this
    }
    fun from(queryBuilderBlock: QueryBuilder.() -> Unit): QueryBuilder {
        val queryBuilder = QueryBuilder(queryBuilderBlock)
        tableFrom = "(${queryBuilder.sql})"
        return this
    }
    fun where(whereClauseString: String): QueryBuilder {
        whereClause.add(QueryBlock(whereClauseString))
        return this
    }
    fun where(queryBlock: QueryBlock): QueryBuilder {
        whereClause.add(queryBlock)
        return this
    }
    fun limit(limitParam: Int, offsetParam: Int? = null): QueryBuilder {
        limit = limitParam
        offset = offsetParam
        return this
    }
    fun orderAsc(field: String): QueryBuilder {
        orderBy.add(field to "ASC")
        return this
    }
    fun orderDesc(field: String): QueryBuilder {
        orderBy.add(field to "DESC")
        return this
    }
    fun addQueryExpression(queryPart: QueryPart): QueryBuilder {
        customQueryParts.add(queryPart)
        return this
    }
    fun leftJoin(tableName: String, joinCondition: String): QueryBuilder {
        tableJoins["left-@join-@$tableName"] = QueryBlock(joinCondition)
        return this
    }
    private fun getFields(): String {
        return fields.joinToString(", ")
    }
    private fun getTableFrom(): String {
        return tableFrom ?: throw FromTableNotSpecifiedException()
    }
    private fun getOrderBy() = orderBy.fold("") { orderByString, currentPair ->
        val (fieldName, ascOrDesc) = currentPair
        "$orderByString, $fieldName $ascOrDesc"
    }.replace(Regex("^,"), "ORDER BY")
    private fun getWhereClause() =  whereClause.fold("") { whereString, currentQueryBlock ->
        "$whereString$$ $currentQueryBlock"
    }.replace(Regex("^\\$\\$"), "WHERE")
    private inline fun <reified T: QueryPart> getCustomQueryPart() =
        customQueryParts
            .filterIsInstance<T>()
            .fold("") { customPartString, currentQueryPart ->
            "$customPartString ${currentQueryPart.queryBlock()}"
        }.replace(Regex("^\\s"), "")
    private fun getJoinsPart() = tableJoins.entries.fold("") { joinString, entry ->
        val (joinName, condition) = entry
        val joinNameParts = joinName.split("-@")
        val tableName = joinNameParts.last()
        val joinStatement =
            joinNameParts.subList(0, joinNameParts.size - 1)
                .joinToString(" ", transform = String::uppercase)

        "$joinString $joinStatement $tableName ON ($condition)"
    }.trim()

    private fun compile(): String {
        val fieldNames = getFields()
        val tableFromName = getTableFrom()
        val orderByString = getOrderBy()
        val whereString = getWhereClause()
        val joinsString = getJoinsPart()
        val customSelectQueryPart = getCustomQueryPart<SelectQueryPart>()
        val customLimitQueryPart = getCustomQueryPart<LimitQueryPart>()
        val customWhereQueryPart = getCustomQueryPart<WhereQueryPart>()
        return """
            |SELECT
            |$customSelectQueryPart
            |$fieldNames FROM $tableFromName
            |$joinsString
            |$whereString
            |$customWhereQueryPart
            |$orderByString
            |${limit.letOrEmptyString("LIMIT $limit")}
            |$customLimitQueryPart
            |${offset.letOrEmptyString("OFFSET $offset")}
        """.replace(Regex("\\s*\\|", MULTILINE), " ")
            .replace(Regex("\\s{2,}", MULTILINE), " ")
            .trim()
    }

    fun copyWith(queryBuilderBlock: QueryBuilder.() -> Unit): QueryBuilder {
        val queryBuilder = this.copy()
        queryBuilder.queryBuilderBlock()
        return queryBuilder
    }

    val sql: String get () = compile()

}