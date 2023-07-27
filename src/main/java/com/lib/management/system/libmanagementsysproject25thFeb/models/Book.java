package com.lib.management.system.libmanagementsysproject25thFeb.models;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Book {
	
	
	//Unidirectional --- having only the foreign key attribute in the current class
	//Birectional 
	
	
	// 
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	
	@Column(name = "bookname")
	private String name;
	
	@Enumerated(value = EnumType.STRING)
	private Genre genre;
	

	private int cost;
	
	private int isbn;
	
	@CreationTimestamp
	private Date createdOn;

	@UpdateTimestamp
	private Date updatedOn;
	
	@ManyToOne
	@JoinColumn
	@JsonIgnoreProperties(value = "bookList")
	private Author author;
	
	
	@ManyToOne
	@JoinColumn
	@JsonIgnoreProperties(value = "bookList")
	private User user;
	
	
	// lets add transcation field later
	
	@OneToMany(mappedBy = "book")
	@JsonIgnoreProperties(value = "book")
	private List<Transaction> transcationList;
	
	

	

}
