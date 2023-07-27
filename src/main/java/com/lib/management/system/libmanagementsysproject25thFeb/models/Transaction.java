package com.lib.management.system.libmanagementsysproject25thFeb.models;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	
	private String transcationId;
	
	
	@ManyToOne
	@JoinColumn
	@JsonIgnoreProperties(value = "transactionList")
	private User user;
	
	
	@ManyToOne
	@JoinColumn
	@JsonIgnoreProperties(value = "transactionList")
	private Book book;
	
	
	@Enumerated(value = EnumType.STRING)
	private TransactionType TransactionType;
	
	@Enumerated(value = EnumType.STRING)
	private TransactionStatus TransactionStatus;
	
	
	
	private int fine;
	
	
	@CreationTimestamp
	private Date createdOn;

	@UpdateTimestamp
	private Date updatedOn;
	
	
	
	

}
