package com.bookapp.web.controller;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bookapp.config.AppConfig;
import com.bookapp.model.service.BookService;
import com.bookapp.model.service.BookServiceImpl;
import com.bookapp.web.entities.Book;

public class Main {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		BookService bookService = ctx.getBean("bookService", BookServiceImpl.class);
		
		List<Book> allBooks = bookService.getAllBooks();
		allBooks.forEach( book -> System.out.println(book) );
		
		bookService.deleteBook(1);
		System.out.println("After Deleting");
		
		allBooks = bookService.getAllBooks();
		allBooks.forEach( book -> System.out.println(book) );
		
		System.out.println("After Adding");
		
		bookService.addBook(new Book("A1Z", "Random Book", "Random Author", 510.0));
		
		allBooks = bookService.getAllBooks();
		
		allBooks.forEach( book -> System.out.println(book) );
		
	}
}
