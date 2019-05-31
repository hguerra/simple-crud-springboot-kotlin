package br.com.carneiro.bookstore.service

import br.com.carneiro.bookstore.domain.Author
import br.com.carneiro.bookstore.domain.Book
import br.com.carneiro.bookstore.repository.BookRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*


@Service
class BookService(private val bookRepository: BookRepository) : BasicCrud<String, Book> {

    fun getByAuthor(name: String): List<Book> = bookRepository.findByAuthorName(name)

    fun getByNameRegex(name: String): List<Book> = bookRepository.findByNameRegex(name)

    override fun getAll(pageable: Pageable): Page<Book> = bookRepository.findAll(pageable)

    override fun getById(id: String): Optional<Book> = bookRepository.findById(id)

    override fun insert(obj: Book): Book = bookRepository.insert(obj)

    @Throws(Exception::class)
    override fun update(obj: Book): Book {
        return if (bookRepository.existsById(obj.isbn)) {
            bookRepository.save(obj)
        } else {
            throw object : Exception("Book not found") {}
        }
    }

    override fun deleteById(id: String): Optional<Book> {
        return bookRepository.findById(id).apply {
            this.ifPresent { bookRepository.delete(it) }
        }
    }
}
