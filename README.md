# Kotlin SQLBuilder - A small, lightweight multiplatform library

<p align="left">
    <a href="LICENSE">
        <img src="https://img.shields.io/badge/license-Apache%202-blue.svg?maxAge=2592000" alt="Apache License 2" />
    </a>
    <a href="https://github.com/KotlinBy/awesome-kotlin">
        <img src="https://kotlin.link/awesome-kotlin.svg" alt="Awesome Kotlin Badge" />
    </a>
</p>

Kotlin SQLBuilder is a lightweight SQL query builder library written in Kotlin Multiplatform.

This project is inspired by [Zeko SQL Builder](https://github.com/darkredz/Zeko-SQL-Builder) and is targeted to have a fun dsl to work with.

Feel free to contact me as well if you want to work and improve this library with me!

## Project Features
- Kotlin multiplatform.
- Kotlin tests and [kotlinx-kover](https://github.com/Kotlin/kotlinx-kover).
- No dependencies.

## TODO
* [ ] Support HAVING and GROUP BY
* [ ] More tests, this is tested with very minimal sql queries

## Getting Started

## Basic Examples
```kotlin
val sqlBuilder = QueryBuilder()                  // Instantiate your builder.
sqlBuilder.from("user")
sqlBuilder.fields("id, first_name, last_name")
sqlBuilder.sql                                   // returns "SELECT id, first_name, last_name from user

val sqlBuilder = QueryBuilder {                  // Also has a friendly, dsl support.
    fields("id, first_name, last_name")          // .sql outputs the same string above
    from("user")
}
```

See [tests]() for more examples on usage.

## Adding to your project via maven central
WIP


