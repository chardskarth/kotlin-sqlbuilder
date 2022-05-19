package io.github.chardskarth.sqlbuilder

sealed class QueryPart(val queryBlock: () -> QueryBlock) {
    class SelectQueryPart(queryBlock: () -> QueryBlock): QueryPart(queryBlock)
    class WhereQueryPart(queryBlock: () -> QueryBlock): QueryPart(queryBlock)
    class LimitQueryPart(queryBlock: () -> QueryBlock): QueryPart(queryBlock)
}