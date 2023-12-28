package com.lib.management.system.libmanagementsysproject25thFeb.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lib.management.system.libmanagementsysproject25thFeb.models.Book;
import com.lib.management.system.libmanagementsysproject25thFeb.models.Transaction;
import com.lib.management.system.libmanagementsysproject25thFeb.models.TransactionType;
import com.lib.management.system.libmanagementsysproject25thFeb.models.User;

public interface TransactionRepo extends JpaRepository<Transaction, Integer> {
	
	
	// i want to find the book and student with transaction type - issue it should in desc wrt to id
	
	
//	List<Transaction> findByBookAndUserAndTransactionTypeOrderByIdDesc(Book book,User user,
//																	TransactionType transactionType);
	
	List<Transaction> findByBookAndUserAndTransactionTypeOrderByIdDesc(
            Book book, User user,
            TransactionType transactionType);
	
	
//	Transaction findTopByBookAndUserAndTransactionTypeOrderByIdDesc(Book book,User user,
//			TransactionType transactionType);
	
	//List<Transaction> findByBookId();
	

}
