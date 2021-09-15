package com.bookapp.model.persistance;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.bookapp.web.entities.Book;
import com.bookapp.web.exceptions.BookNotFoundException;

@Repository
@Primary
public class BookDaoImplHibt implements BookDao{

	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	

	@Override
	public List<Book> getAllBooks() {
		return getSession().createQuery("Select book from Book book").getResultList();
	}

	@Override
	public Book getBookById(int id) {
		
		Book book = getSession().find(Book.class,id);
		
		if(book == null) {
			throw new BookNotFoundException("Book not found and its id: " + id);
		}
		
		return book;
	
	}
	
	@Override
	public void updateBook(int id, Book book) {
		
		Book bookToBeUpdated = getBookById(id);
		bookToBeUpdated.setPrice(book.getPrice());
		
		getSession().merge(bookToBeUpdated);
		
	}
	
	@Override
	public Book addBook(Book book) {
		getSession().save(book);
		return book;
	}

	@Override
	public void deleteBook(int id) {
		Book book = getBookById(id);
		getSession().delete(book);
	}
	
}
