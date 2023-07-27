package com.lib.management.system.libmanagementsysproject25thFeb.models;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
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
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int userId;
	

	private String name;
	
	@Column(unique = true, nullable = false)
	private String email;
	
	private String ph;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnoreProperties(value = "user")
	private List<Book> bookList;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnoreProperties(value = "user")
	private List<Transaction> transactionList;
	
	
	@CreationTimestamp
	private Date createdOn;

	@UpdateTimestamp
	private Date updatedOn;
	
	

}
