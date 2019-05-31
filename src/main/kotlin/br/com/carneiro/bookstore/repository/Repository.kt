package br.com.carneiro.bookstore.repository

import br.com.carneiro.bookstore.domain.Author
import br.com.carneiro.bookstore.domain.Book
import org.springframework.data.mongodb.repository.MongoRepository

interface AuthorRepository : MongoRepository<Author, String> {}

interface BookRepository : MongoRepository<Book, String> {
    fun findByAuthorName(name: String): List<Book>

    fun findByNameRegex(name: String): List<Book>
}
