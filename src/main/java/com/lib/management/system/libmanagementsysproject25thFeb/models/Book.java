package com.lib.management.system.libmanagementsysproject25thFeb.models;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
import lombok. Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Book {
	
	//1)Unidirectional--having only rhe foreign key atribute in the current class;
	//when author id is only in book table but mot any forign key in author
	//2)Bidirectional
	
	
//	@GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	@Id
	private int id;
	
	@Column(name="bookname")
	private String name;
	
	private int cost;
	
	private int isbn;
	
	@CreationTimestamp
	private Date createdOn;
	
	@UpdateTimestamp
	private Date updatedOn;
	
	 //reference to author
	//why to have author name just have entire 
	
	//book to author relationship
	//many book can be written by one author
	
	@ManyToOne
	@JoinColumn //to have antoher column with id authoir id on book table
	private Author author;
	
	
	//book to user or student
	//many book can be issue  by one student so
	//One book can be issued by many student
	
	@ManyToOne
	@JoinColumn  //to have student id as well in book table we will require to know is its issued //unidirefctional relationship
	private User user;
	
	//book should be related to author AND user(user are student and teacher);
	//we are assuming one book can be written by one author
	// 
	//what are the relation between BOOK and AUTHOR
	//what are the relation between AUTHOR and BOOK.
	
	//add transaction field //on one book many transaction can be done
	                    //needs to be checked//
	
	@OneToMany(mappedBy="book")//object of the book clas which is present in transaction
	private List<Transaction> transactionList;
	
}
