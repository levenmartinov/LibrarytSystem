// File: BookService.java
package com.tpe.service;

import com.tpe.domain.Book;
import com.tpe.exception.EntityNotFoundException;
import com.tpe.repository.BookRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    @Autowired
    private final BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book with ID " + id + " not found!"));
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book updatedBook) {
        Book existingBook = getBookById(id);
        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setPages(updatedBook.getPages());
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setAddress(updatedBook.getAddress()); // Doğru alan
        return bookRepository.save(existingBook);
    }


    public void deleteBook(Long id) {
        Book book = getBookById(id);
        bookRepository.delete(book);
    }
}
