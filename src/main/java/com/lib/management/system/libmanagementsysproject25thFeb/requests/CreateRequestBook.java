package com.lib.management.system.libmanagementsysproject25thFeb.requests;

import java.util.List;

import com.lib.management.system.libmanagementsysproject25thFeb.models.Author;
import com.lib.management.system.libmanagementsysproject25thFeb.models.Book;
import com.lib.management.system.libmanagementsysproject25thFeb.models.Genre;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class CreateRequestBook {

	@NotBlank
	private String name;

	private int cost;

	@NotNull
	private Genre genre;
	


	private String authorName;

	@NotBlank
	@Email
	private String email;
	
	
	public Book to() {
		
		Author author = Author.builder().name(authorName).email(email).build();
		
		
		return Book.builder().name(name).genre(genre).author(author).build();
		
		
	}
	

}
