package io.github.chardskarth.sqlbuilder.extension

fun Int?.letOrEmptyString(string: String) = this?.let { string } ?: ""
