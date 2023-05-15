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

public class Author {
	
//	@GeneratedValue(strategy=GenerationType.AUTO )
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	@Id
	private int authorId;
	
	private String name;
	
	private String email;
	
	
	//author is related to book so
	//1 author can write many book
	//1:N
	
	@OneToMany(mappedBy = "author")//defining bidirectional relationship
	//@JsonIgnoreProperties(value= {"author","updatedOn"})
	List<Book> bookList;
	@CreationTimestamp
	private Date createdOn;
	
	@UpdateTimestamp
	private Date updatedOn;
}
