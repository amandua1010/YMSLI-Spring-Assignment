package com.bookapp.model.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.model.persistance.BookDao;
import com.bookapp.web.entities.Book;

@Service(value = "bookService")
@Transactional
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;
	
	public List<Book> getAllBooks() {
		return bookDao.getAllBooks();
	}

	public Book addBook(Book book) {
		return bookDao.addBook(book);
	}

	@Loggable
	public void deleteBook(int id) {
		bookDao.deleteBook(id);
	}	
	
	public void updateBook(int id, Book book) {
		bookDao.updateBook(id, book);
	}

	public Book getBookById(int id) {
		return bookDao.getBookById(id);
	}

}
