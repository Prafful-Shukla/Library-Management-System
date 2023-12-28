package com.lib.management.system.libmanagementsysproject25thFeb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lib.management.system.libmanagementsysproject25thFeb.services.TransactionService;

@RestController
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;

	
	@PostMapping("/transaction/issue")
	public void issueBook(@RequestParam("studentId") int studentId, @RequestParam("bookId") int bookId) throws Exception {
		transactionService.issueBook(studentId,bookId);
	}
	
	
	@PostMapping("/transaction/return")
	public void returnBook(@RequestParam("studentId") int studentId, @RequestParam("bookId") int bookId) throws Exception {
		transactionService.returnBook(studentId,bookId);
	}
	
	
	
	
}
