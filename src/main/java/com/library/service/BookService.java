package com.library.service;

import com.library.enums.BookStatus;
import com.library.enums.Genre;
import com.library.model.Author;
import com.library.model.Book;
import com.library.model.Member;
import com.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void insert(String title,
                       Genre genre,
                       BookStatus status,
                       Author author,
                       Member borrowedBy,
                       int publishedYear) {

        Book book = new Book();

        book.setTitle(title);
        book.setGenre(genre);
        book.setStatus(status);
        book.setAuthor(author);
        book.setBorrowedBy(borrowedBy);
        book.setPublishedYear(publishedYear);

        bookRepository.insert(book);
    }

    public Book findById(int id) {
        return bookRepository.findById(id);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}