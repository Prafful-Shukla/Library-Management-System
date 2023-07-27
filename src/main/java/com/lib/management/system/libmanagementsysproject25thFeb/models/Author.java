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
import jakarta.validation.constraints.NotNull;
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

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int authorId;
	
	@Column(nullable = false )
	private String name;
	
	@Column(unique = true)
	private String email;
	

	
	@OneToMany(mappedBy = "author")
	@JsonIgnoreProperties(value = {"author","updatedOn"})
	List<Book> bookList;
	
	@CreationTimestamp
	private Date createdOn;

	@UpdateTimestamp
	private Date updatedOn;
}
