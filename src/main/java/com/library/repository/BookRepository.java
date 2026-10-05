package com.library.repository;

import com.library.model.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class BookRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insert(Book book) {
        entityManager.persist(book);
    }

    public Book findById(int id) {
        return entityManager.find(Book.class, id);
    }

    public List<Book> findAll() {
        String jpql = "select b from Book b";

        return entityManager
                .createQuery(jpql, Book.class)
                .getResultList();
    }
}