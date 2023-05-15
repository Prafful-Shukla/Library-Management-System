  package com.lib.management.system.libmanagementsysproject25thFeb.models;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

public class Transaction {
	
	
//	@GeneratedValue(strategy =GenerationType.AUTO)
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	private int id;  //auto increment //will tell how many transaction happen in a day or something like that
	
	private String transactionId;
	
	
	//many transaction can  be done by one user
	@ManyToOne
	@JoinColumn //in transaction we want user reference thats why
	private User user;
	
	//many transaction can be of 
	@ManyToOne
	@JoinColumn
	private Book book;
	
	@CreationTimestamp
	private Date createdOn;
	
	@UpdateTimestamp
	private Date updatedOn;
	
	
	//--FINE
	//fine will be between book and user
	//is book ka itna fine laga
	
	//we need      transaction status i.e 
	//we also need transaction type 
	
	//NOTE -when u give transaction type as enum it will not pick the value
	//for this therefore there is a annotation enumerated
	
	//u can define ordinal or string to store
	//ordinal is like it will store index of string for exameple here pending is index 1 and so on(look enum string)
	@Enumerated(value=EnumType.STRING)
	private TransactionStatus TransactionStatus;
	
	@Enumerated(value=EnumType.STRING)
	private TransactionType TransactionType;
	
	private int fine;
}
