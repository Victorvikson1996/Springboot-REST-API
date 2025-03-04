package com.jetbrains.victor.springboot_kotlin

import org.springframework.data.jpa.repository.JpaRepository


interface  ArticleRepository : JpaRepository<Article, Long> {
    fun findAllByOrderByCreatedAtDesc(): Iterable<Article>
    fun findBySlug(slug: String): Article?

}