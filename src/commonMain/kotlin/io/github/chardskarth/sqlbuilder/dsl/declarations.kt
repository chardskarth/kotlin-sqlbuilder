package io.github.chardskarth.sqlbuilder.dsl

import io.github.chardskarth.sqlbuilder.QueryBlock

infix fun String.eq(value: String): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.eq(this, value)
}

infix fun String.eq(value: Int): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.eq(this, value)
}

infix fun String.eq(value: Long): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.eq(this, value)
}

infix fun String.eq(value: Double): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.eq(this, value)
}

infix fun String.eq(value: Any): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.eq(this, value)
}

infix fun String.neq(value: String): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.neq(this, value)
}

infix fun String.neq(value: Int): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.neq(this, value)
}

infix fun String.neq(value: Long): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.neq(this, value)
}

infix fun String.neq(value: Double): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.neq(this, value)
}

infix fun String.neq(value: Any): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.neq(this, value)
}

infix fun String.greater(value: String): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.greater(this, value)
}

infix fun String.greaterEq(value: String): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.greaterEq(this, value)
}

infix fun String.less(value: String): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.less(this, value)
}

infix fun String.lessEq(value: String): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.lessEq(this, value)
}

infix fun String.greater(value: Int): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.greater(this, value)
}

infix fun String.greaterEq(value: Int): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.greaterEq(this, value)
}

infix fun String.less(value: Int): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.less(this, value)
}

infix fun String.lessEq(value: Int): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.lessEq(this, value)
}

infix fun String.greater(value: Long): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.greater(this, value)
}

infix fun String.greaterEq(value: Long): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.greaterEq(this, value)
}

infix fun String.less(value: Long): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.less(this, value)
}

infix fun String.lessEq(value: Long): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.lessEq(this, value)
}

infix fun String.greater(value: Double): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.greater(this, value)
}

infix fun String.greaterEq(value: Double): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.greaterEq(this, value)
}

infix fun String.less(value: Double): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.less(this, value)
}

infix fun String.lessEq(value: Double): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.lessEq(this, value)
}

infix fun String.greater(value: Any): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.greater(this, value)
}

infix fun String.greaterEq(value: Any): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.greaterEq(this, value)
}

infix fun String.less(value: Any): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.less(this, value)
}

infix fun String.lessEq(value: Any): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.lessEq(this, value)
}

infix fun QueryBlock.eq(value: String): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.eq(this.toString(), value)
}

infix fun QueryBlock.eq(value: Int): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.eq(this.toString(), value)
}

infix fun QueryBlock.eq(value: Long): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.eq(this.toString(), value)
}

infix fun QueryBlock.eq(value: Double): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.eq(this.toString(), value)
}

infix fun QueryBlock.eq(value: Any): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.eq(this.toString(), value)
}

infix fun QueryBlock.neq(value: String): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.neq(this.toString(), value)
}

infix fun QueryBlock.neq(value: Int): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.neq(this.toString(), value)
}

infix fun QueryBlock.neq(value: Long): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.neq(this.toString(), value)
}

infix fun QueryBlock.neq(value: Double): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.neq(this.toString(), value)
}

infix fun QueryBlock.neq(value: Any): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.neq(this.toString(), value)
}

infix fun QueryBlock.greater(value: String): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.greater(this.toString(), value)
}

infix fun QueryBlock.greaterEq(value: String): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.greaterEq(this.toString(), value)
}

infix fun QueryBlock.less(value: String): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.less(this.toString(), value)
}

infix fun QueryBlock.lessEq(value: String): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.lessEq(this.toString(), value)
}

infix fun QueryBlock.greater(value: Int): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.greater(this.toString(), value)
}

infix fun QueryBlock.greaterEq(value: Int): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.greaterEq(this.toString(), value)
}

infix fun QueryBlock.less(value: Int): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.less(this.toString(), value)
}

infix fun QueryBlock.lessEq(value: Int): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.lessEq(this.toString(), value)
}

infix fun QueryBlock.greater(value: Long): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.greater(this.toString(), value)
}

infix fun QueryBlock.greaterEq(value: Long): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.greaterEq(this.toString(), value)
}

infix fun QueryBlock.less(value: Long): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.less(this.toString(), value)
}

infix fun QueryBlock.lessEq(value: Long): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.lessEq(this.toString(), value)
}

infix fun QueryBlock.greater(value: Double): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.greater(this.toString(), value)
}

infix fun QueryBlock.greaterEq(value: Double): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.greaterEq(this.toString(), value)
}

infix fun QueryBlock.less(value: Double): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.less(this.toString(), value)
}

infix fun QueryBlock.lessEq(value: Double): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.lessEq(this.toString(), value)
}

infix fun QueryBlock.greater(value: Any): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.greater(this.toString(), value)
}

infix fun QueryBlock.greaterEq(value: Any): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.greaterEq(this.toString(), value)
}

infix fun QueryBlock.less(value: Any): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.less(this.toString(), value)
}

infix fun QueryBlock.lessEq(value: Any): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.lessEq(this.toString(), value)
}

infix fun String.like(value: String): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.like(this, value)
}

infix fun String.notLike(value: String): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.notLike(this, value)
}

infix fun String.regexp(value: String): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.regexp(this, value)
}

infix fun String.notRegexp(value: String): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.notRegexp(this, value)
}

infix fun String.match(value: String): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.match(this, value)
}

infix fun List<String>.match(value: String): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.match(this, value)
}

infix fun String.isNotNull(value: Boolean): QueryBlock {
    if (value) {
        return io.github.chardskarth.sqlbuilder.sqloperators.isNotNull(this)
    }
    return QueryBlock("", "")
}

infix fun String.isNull(value: Boolean): QueryBlock {
    if (value) {
        return io.github.chardskarth.sqlbuilder.sqloperators.isNull(this)
    }
    return QueryBlock("", "")
}

infix fun String.inList(values: String): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.inList(this, values)
}

infix fun String.inList(values: List<Any>): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.inList(this, values)
}

infix fun String.inList(values: Array<*>): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.inList(this, values)
}

infix fun String.inList(valueSize: Int): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.inList(this, valueSize)
}

infix fun String.notInList(values: String): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.notInList(this, values)
}

infix fun String.notInList(values: List<Any>): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.notInList(this, values)
}

infix fun String.notInList(values: Array<*>): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.notInList(this, values)
}

infix fun String.notInList(valueSize: Int): QueryBlock {
    return io.github.chardskarth.sqlbuilder.sqloperators.notInList(this, valueSize)
}

infix fun QueryBlock.and(value: QueryBlock): QueryBlock {
    return QueryBlock(this.toString(), " AND ", value.toString())
}

infix fun QueryBlock.or(value: QueryBlock): QueryBlock {
    return QueryBlock(this.toString(), " OR ", value.toString())
}

infix fun String.between(values: Pair<*, *>): QueryBlock {
    val value1 = values.first
    if (value1 is String) {
        val value2 = values.second.toString()
        return io.github.chardskarth.sqlbuilder.sqloperators.between(this, value1, value2)
    } else if (value1 is Int) {
        val value2 = values.second as Int
        return io.github.chardskarth.sqlbuilder.sqloperators.between(this, value1, value2)
    } else if (value1 is Long) {
        val value2 = values.second as Long
        return io.github.chardskarth.sqlbuilder.sqloperators.between(this, value1, value2)
    } else if (value1 is Double) {
        val value2 = values.second as Double
        return io.github.chardskarth.sqlbuilder.sqloperators.between(this, value1, value2)
    } else {
        val value2 = values.second
        return io.github.chardskarth.sqlbuilder.sqloperators.between(this, value1.toString(), value2.toString())
    }
    return QueryBlock("", "")
}

