package com.jetbrains.victor.springboot_kotlin

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/v1/articles")
class ArticleController {

    var articles = mutableListOf(Article(title = "My Title", content = "my content"))

    @GetMapping
    fun articles(): MutableList<Article>  = articles

    @GetMapping("/{slug}")
    fun articles(@PathVariable slug: String): Article = articles.find {
        article: Article ->  article.title == slug
    } ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

    @PostMapping
    fun newArticle(@RequestBody article: Article): Article {
        articles.add(article)
        return article
    }

    @PutMapping("/{slug}")
    fun updateArticle(@RequestBody article: Article, @PathVariable slug: String): Article {
        val existingArticle = articles.find {it.slug ==
                slug} ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
        existingArticle.content = article.content;
        return  article
    }

    @DeleteMapping("/{slug}")
    fun deleteArticle(@PathVariable slug: String) {
        articles.removeIf{article -> article.title == slug}
    }

}



