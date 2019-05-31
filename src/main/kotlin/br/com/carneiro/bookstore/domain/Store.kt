package br.com.carneiro.bookstore.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate

@Document
data class Author(
    @Id
    val id: String? = null,
    val name: String,
    val birthDate: LocalDate
)

@Document
data class Book(
    @Id
    val isbn: String,
    val name: String,
    @DBRef
    val author: Author,
    val publishedYear: Int
)
