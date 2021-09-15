package com.bookapp.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookapp.model.service.BookService;
import com.bookapp.web.entities.Book;

@Controller
public class BookController {
	
	private BookService bookService;

	@Autowired
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
//	----------- Get all books method -----------	
	@GetMapping("allbooks")
	public String getAllBooks(ModelMap map) {
		
		map.addAttribute("books", bookService.getAllBooks());
		return "showAllBooks";
		
	}
	
//	----------- Add new book method -----------
	@GetMapping("addBook")
	public String addBookGet(ModelMap map) {
		
		map.addAttribute("book", new Book());
		return "addBook";
		
	}
	
	@PostMapping("addBook")
	public String addBookPost(@ModelAttribute(name = "book") @Valid Book book, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "addbook";
		} 
		
		else {
			if (book.getId() == 0) {
				bookService.addBook(book);
			} 
			else {
				bookService.updateBook(book.getId(), book);
			}
			
			return "redirect:/allbooks";
		}
		
	}
	
//	----------- Delete Book -----------
	@GetMapping("deleteBook")
	public String deleteBookById(@RequestParam(name="id") int id) {
		
		bookService.deleteBook(id);
		return "redirect:/allbooks";
		
	}
	
//	----------- Update Book -----------
	@GetMapping("updateBook")
	public String updateBookById(@RequestParam (name="id")int id, ModelMap map) {
		
		Book book = bookService.getBookById(id);
		map.addAttribute("book", book);
		
		return "updateBook";
		
	}

}
