package com.lib.management.system.libmanagementsysproject25thFeb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lib.management.system.libmanagementsysproject25thFeb.dao.BookRepo;
import com.lib.management.system.libmanagementsysproject25thFeb.models.Author;
import com.lib.management.system.libmanagementsysproject25thFeb.models.Book;

@Service
public class BookService {
	
	
	@Autowired
	BookRepo bookRepo;
	
	
	@Autowired
	AuthorService authorService;
	
	

	public void createBook(Book book) {
		//we will have to write the logic for insertion
		// want to add logic to insert author also 
		
		
	Author author = authorService.createOrGetAuthor(book.getAuthor());
	
	 	book.setAuthor(author);
		bookRepo.save(book);
		
		
	}

	public List<Book> getBooks() {
		return bookRepo.findAll();
		
	}

	public Book getBookById(int bookId) {
		return bookRepo.findById(bookId).orElse(null);
		
	}

}
