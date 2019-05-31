package br.com.carneiro.bookstore.resource

import br.com.carneiro.bookstore.domain.Book
import br.com.carneiro.bookstore.service.BookService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("api/book")
class BookResource(private val bookService: BookService) {
    @GetMapping
    fun getAll(pageable: Pageable): Page<Book> = bookService.getAll(pageable)

    @GetMapping("{isbn}")
    fun getByIsbn(@PathVariable isbn: String): Optional<Book> = bookService.getById(isbn)

    @GetMapping("/name/{regex}")
    fun getByName(@PathVariable regex: String): List<Book> = bookService.getByNameRegex(regex)

    @GetMapping("/author/{name}")
    fun getByAuthor(@PathVariable name: String): List<Book> = bookService.getByAuthor(name)

    @PostMapping
    fun insert(@RequestBody book: Book): Book = bookService.insert(book)

    @PutMapping
    fun update(@RequestBody book: Book): Book = bookService.update(book)

    @DeleteMapping("{isbn}")
    fun deleteByIsbn(@PathVariable isbn: String): Optional<Book> = bookService.deleteById(isbn)
}
