package com.lib.management.system.libmanagementsysproject25thFeb.models;

import java.util.Date;

import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class User {
	
	@GeneratedValue(strategy=GenerationType.AUTO )
	@Id
	private int userId;
	
	private String name;
	
	
	private String email;
	
	private String phNum;
	
	//one 1 user/student can issue Many book (will add limit too later upto 5 books)
	@OneToMany(mappedBy="user")//check this by changing name of object user in book        
	private List<Book> bookList;
	
	//do we need transaction in book??
	//
	@OneToMany(mappedBy="user")//check this by changing name of object user in book        
	private List<Transaction> transactionList;
	 
	
	@CreationTimestamp
	private Date createdOn;
	
	@UpdateTimestamp
	private Date updatedOn;
}
