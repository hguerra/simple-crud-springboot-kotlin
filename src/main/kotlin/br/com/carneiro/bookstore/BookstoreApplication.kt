package br.com.carneiro.bookstore

import br.com.carneiro.bookstore.domain.Author
import br.com.carneiro.bookstore.domain.Book
import br.com.carneiro.bookstore.repository.AuthorRepository
import br.com.carneiro.bookstore.repository.BookRepository
import br.com.carneiro.bookstore.util.toLocalDate
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BookstoreApplication(private val bookRepository: BookRepository, private val authorRepository: AuthorRepository) : ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        if (bookRepository.count() < 1) createBooks()
    }

    private fun createBooks() {
        cleanCollections()

        val george = authorRepository.insert(Author(name = "George R. R. Martin",birthDate =  "20-09-1948".toLocalDate()))
        val tolkien = authorRepository.insert(Author(name = "J. R. R. Tolkien", birthDate = "03-01-1892".toLocalDate()))

        val books = listOf(
            Book(isbn = "9780553573428",name = "A Storm of Swords", publishedYear = 2011, author = george),
            Book(isbn = "9780553579901", name = "A clash of kings", publishedYear = 2005, author = george),
            Book(isbn = "9780618260553", name = "The Return of the King", publishedYear = 2002, author = tolkien)
        )

        bookRepository.insert(books)
    }

    private fun cleanCollections() {
        bookRepository.deleteAll()
        authorRepository.deleteAll()
    }
}

fun main(args: Array<String>) {
    runApplication<BookstoreApplication>(*args)
}
