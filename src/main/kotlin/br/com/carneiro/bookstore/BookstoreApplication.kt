package br.com.carneiro.bookstore

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class BookstoreApplication

@RestController
class MainController {
    @GetMapping
    fun index() = "Hello world"
}

fun main(args: Array<String>) {
    runApplication<BookstoreApplication>(*args)
}
