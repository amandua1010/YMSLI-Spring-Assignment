package com.bookapp.model.persistance;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bookapp.web.entities.Book;

@Primary
@Repository
public class BookDaoImplJdbc implements BookDao{

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Book> getAllBooks() {
		
		String getAllBooksQuery = "select * from book";
		List<Book> books = jdbcTemplate.query(getAllBooksQuery, new BookRowMapper());
		
		return books;
		
	}
	
	@Override
	public Book addBook(Book book) {
		
		String addBookQuery = "insert into book(isbn, title, author, price) values(?, ?, ?, ?)";
		int update = jdbcTemplate.update(addBookQuery, new Object[] {book.getIsbn(), book.getTitle(), book.getAuthor(), book.getPrice()});
		book.setId(update);
		
		return book;
		
	}

	@Override
	public void deleteBook(int id) {
		
		String deleteBookQuery = "delete from book where id = ?";
		jdbcTemplate.update(deleteBookQuery, new Object[] {id});
		
	}

	@Override
	public void updateBook(int id, Book book) {
		
		String updateBookIdQuery = "update book set price = ? where id = ?";
		jdbcTemplate.update(updateBookIdQuery, new Object[] {book.getPrice(), id});
	
	}

	@Override
	public Book getBookById(int id) {
		
		String getBookByIdQuery = "select * from book where id = ?";
		Book book = jdbcTemplate.queryForObject(getBookByIdQuery, new BookRowMapper(), id);
		
		return book;
	
	}
	
}
