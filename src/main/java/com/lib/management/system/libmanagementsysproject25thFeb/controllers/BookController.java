package com.lib.management.system.libmanagementsysproject25thFeb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lib.management.system.libmanagementsysproject25thFeb.models.Book;
import com.lib.management.system.libmanagementsysproject25thFeb.requests.CreateRequestBook;
import com.lib.management.system.libmanagementsysproject25thFeb.services.BookService;

import jakarta.validation.Valid;

@RestController
public class BookController {
	
	
	//addbook
	//getBookById
	//getAllBook
	
	@Autowired
	BookService bookService;
	
	
	@PostMapping("/book")
	public void createBook(@Valid @RequestBody CreateRequestBook bookCreateRequest) {
		bookService.createBook(bookCreateRequest.to());
	}
	
	@GetMapping("/book/all")
	public List<Book> getBooks() {
	return	bookService.getBooks();
	}
	
	@GetMapping("/book/{bookId}")
	public Book getBookById(@PathVariable("bookId") int bookId ) {
		return bookService.getBookById(bookId);
	}
	
	
	

}
