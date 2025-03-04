package com.jetbrains.victor.springboot_kotlin

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime


@Entity
data class Article(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0,
    var title: String,
    var content: String,
    val createdAT: LocalDateTime = LocalDateTime.now(),
    // https://blog/my-first-title My First Title
    val slug: String = title.toSlug(),
)