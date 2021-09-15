package com.bookapp.web.controller;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bookapp.model.config.AppConfig;
import com.bookapp.model.service.BookService;
import com.bookapp.web.entities.Book;

public class Main {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		BookService bookService = ctx.getBean("bookService",BookService.class);

		Book book1 = new Book("A1X", "Maths Book", "Author 1", 450);
		Book book2 = new Book("B1Y", "C++ Book", "Author 2", 500);

		bookService.addBook(book1);
		bookService.addBook(book2);

		List<Book> allBooks = bookService.getAllBooks();
		allBooks.forEach(book -> System.out.println(book));

		bookService.deleteBook(1);
		
	}
	
}
