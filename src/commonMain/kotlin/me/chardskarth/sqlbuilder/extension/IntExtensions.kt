package me.chardskarth.sqlbuilder.extension

fun Int?.letOrEmptyString(string: String) = this?.let { string } ?: ""
