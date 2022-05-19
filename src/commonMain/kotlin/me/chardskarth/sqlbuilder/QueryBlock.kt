package me.chardskarth.sqlbuilder

class QueryBlock {
    private var left: String = ""
    private var right: String = ""
    private var center: String = ""

    constructor(left: String, center: String, right: String) {
        this.center = center
        this.left = left
        this.right = right
    }

    constructor(left: String, right: String) {
        this.left = left
        this.right = right
    }

    constructor(center: String) {
        this.center = center
    }

//    fun getStatement(): String = "$left $center $right"

    override fun toString(): String {
        return "$left $center $right"
    }
}