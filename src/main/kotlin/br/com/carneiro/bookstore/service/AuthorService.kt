package br.com.carneiro.bookstore.service

import br.com.carneiro.bookstore.domain.Author
import br.com.carneiro.bookstore.repository.AuthorRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class AuthorService(private val authorRepository: AuthorRepository) : BasicCrud<String, Author> {

    override fun getAll(pageable: Pageable): Page<Author> = authorRepository.findAll(pageable)

    override fun getById(id: String): Optional<Author> = authorRepository.findById(id)

    override fun insert(obj: Author): Author = authorRepository.insert(obj)

    @Throws(Exception::class)
    override fun update(obj: Author): Author {
        return if (obj.id != null && authorRepository.existsById(obj.id)) {
            authorRepository.save(obj)
        } else {
            throw object : Exception("The author does not exists") {}
        }
    }

    override fun deleteById(id: String): Optional<Author> {
        return authorRepository.findById(id).apply {
            this.ifPresent {
                authorRepository.delete(it)
            }
        }
    }
}
