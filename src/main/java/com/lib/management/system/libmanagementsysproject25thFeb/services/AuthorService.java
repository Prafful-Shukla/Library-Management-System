package com.lib.management.system.libmanagementsysproject25thFeb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lib.management.system.libmanagementsysproject25thFeb.dao.AuthorRepo;
import com.lib.management.system.libmanagementsysproject25thFeb.models.Author;

@Service
public class AuthorService {

	// author will exist or it will not
	// if it will not exist will have to create a author
	// if author exist then will have to use the same

	@Autowired
	AuthorRepo authorRepo;

	public Author createOrGetAuthor(Author author){
		
		Author authorFromDb = authorRepo.findAuthor(author.getEmail());// get it 
		if(authorFromDb == null) {
			authorFromDb = 	authorRepo.save(author);// create 
		}
		
		
		return authorFromDb;
		
		
	}

}
