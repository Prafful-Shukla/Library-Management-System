package com.lib.management.system.libmanagementsysproject25thFeb.services;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.lib.management.system.libmanagementsysproject25thFeb.dao.TransactionRepo;
import com.lib.management.system.libmanagementsysproject25thFeb.models.Book;
import com.lib.management.system.libmanagementsysproject25thFeb.models.Transaction;
import com.lib.management.system.libmanagementsysproject25thFeb.models.TransactionStatus;
import com.lib.management.system.libmanagementsysproject25thFeb.models.TransactionType;
import com.lib.management.system.libmanagementsysproject25thFeb.models.User;

@Service
public class TransactionService {

	@Value("${student.book.quota}")
	int studentBookQuota;
	
				
	@Value("${book.return.days}")
	int daysLimit;
			
	@Value("${book.fine.day}")
	int finePerDay;
	
			
			

	@Autowired
	StudentService studentService;

	@Autowired
	BookService bookService;

	@Autowired
	TransactionRepo transactionRepo;
	
	

	public String issueBook(int studentId, int bookId) throws Exception {
		// student is present or not
		// book is present or not and book is available
		// Students book limit or quota
		// create txn with inital state as pending
		// Transaction type to issue
		// Make the book unavailable and assign it to a student
		// update the txn successfull

		User student = studentService.getStudentId(studentId);
		if (student == null) {
			throw new Exception("Student is not present, unable to issue the book");
		}

		Book book = bookService.getBookById(bookId);

		if (book.getUser() != null) {
			throw new Exception("Book is already issued to someone else, unable to issue the book");
		}
		
		if(student.getBookList().size()>=studentBookQuota) {
			throw new Exception("Student quota has reached, unable to issue the book");
		}
		
		//IN ORDER TO SAVE TRANSACTION WE HAVE TO CREATE TRANSACTION
		Transaction transaction = Transaction.builder()
										.book(book)
										.user(student)
										.transactionType(TransactionType.ISSUE)
										.TransactionStatus(TransactionStatus.PENDING)//INITIAL PENDING AFTER SAVING IT SHOULD BE SUCCESFULL BUT HOW TO TO THIS
										.transcationId(UUID.randomUUID().toString())
										.build();
		
		transactionRepo.save(transaction);
		//if while save there was some error
		//else
		//book.setUser(student)  
		
		try {
		
		book.setUser(student);
		bookService.createBook(book); // THIS WILL UPDATE THE EXISTING BOOK AS ITS SAVE
		transaction.setTransactionStatus(TransactionStatus.SUCCESS);
		transactionRepo.save(transaction);
		} catch(Exception e) {
			
			book.setUser(null);
			bookService.createBook(book);
			transaction.setTransactionStatus(TransactionStatus.FAILED);
			transactionRepo.save(transaction);
		} 
		
		return transaction.getTranscationId();
	}

	public String returnBook(int studentId, int bookId) throws Exception {
		//check whteher the book is assigned to the student or not?
		//check the fine and update the trasaction 
		//we will create the txn with the pending status
		//Remove the student as assignee and Make the book available --- user id should be set to null
		//update the txn with status - success
		
		
		
		User student = studentService.getStudentId(studentId);
		
		Book book = bookService.getBookById(bookId);
		
		
		if(student == null || book == null || book.getUser() == null 
						   || book.getUser().getUserId() !=studentId) {
			throw new Exception("Book or student is either not present or book is not assgned to the student unable to return");
				
		}
		
		List<Transaction> issueTxnList = transactionRepo.findByBookAndUserAndTransactionTypeOrderByIdDesc(
				book, student, TransactionType.ISSUE);
		
		
		Transaction issueTnx = issueTxnList.get(0);
		
		//to check the fine scenario
		long issueTimeInMilliSec = issueTnx.getUpdatedOn().getTime();
		long currentTimeInMilliSec = System.currentTimeMillis();
		
		
		long timeDiff = currentTimeInMilliSec - issueTimeInMilliSec;
			//convert it into days
		long numberNumOfDaysPassed = TimeUnit.DAYS.convert(timeDiff,TimeUnit.MILLISECONDS);//class timeunit 
		
		int fine = 0;
		if(numberNumOfDaysPassed > daysLimit) {
			fine = (int) ((numberNumOfDaysPassed - daysLimit) * finePerDay);
		}
		
		
		
		Transaction transaction = Transaction.builder()
				.transcationId(UUID.randomUUID().toString())
				.transactionType(TransactionType.RETURN)
				.TransactionStatus(TransactionStatus.PENDING)
				.book(book)
				.user(student)
				.fine(fine)
				.build();
transactionRepo.save(transaction);






try {
	//detach state           when we try to remove relation between two identity
	book.setUser(null);
	bookService.createBook(book); // THIS WILL UPDATE THE EXISTING BOOK AS ITS SAVE
	transaction.setTransactionStatus(TransactionStatus.SUCCESS);
	transactionRepo.save(transaction); // persist
	
	} catch(Exception e) {
		
		book.setUser(student);
		bookService.createBook(book);
		transaction.setTransactionStatus(TransactionStatus.FAILED);
		transactionRepo.save(transaction);
	} 





	return transaction.getTranscationId();

	}

}
