package com.jetbrains.victor.springboot_kotlin

import java.time.LocalDate
import java.time.LocalDateTime

data class Article(
    var title: String,
    var content: String,
    val createdAT: LocalDateTime = LocalDateTime.now(),


    // https://blog/my-first-title My First Title

    val slug: String = title.toSlug(),
) {

}
