package br.com.carneiro.bookstore.resource

import br.com.carneiro.bookstore.domain.Author
import br.com.carneiro.bookstore.service.AuthorService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("api/author")
class AuthorResource(private val authorService: AuthorService) {
    @GetMapping
    fun getAll(pageable: Pageable): Page<Author> = authorService.getAll(pageable)

    @GetMapping("{id}")
    fun getById(@PathVariable id: String): Optional<Author> = authorService.getById(id)

    @PostMapping
    fun insert(@RequestBody author: Author): Author = authorService.insert(author)

    @PutMapping
    fun update(@RequestBody author: Author): Author = authorService.update(author)

    @DeleteMapping("{id}")
    fun deleteById(@PathVariable id: String): Optional<Author> = authorService.deleteById(id)
}
