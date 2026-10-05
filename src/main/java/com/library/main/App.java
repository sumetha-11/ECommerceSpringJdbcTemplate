package com.library.main;

import com.library.config.AppConfig;
import com.library.model.Book;
import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        BookService bookService =
                context.getBean(BookService.class);

        /* Find All Books */
        List<Book> list = bookService.findAll();

        System.out.println("All Books:");

        list.forEach(System.out::println);
    }
}