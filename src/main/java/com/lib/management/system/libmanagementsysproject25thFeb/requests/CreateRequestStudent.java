package com.lib.management.system.libmanagementsysproject25thFeb.requests;

import com.lib.management.system.libmanagementsysproject25thFeb.models.Genre;
import com.lib.management.system.libmanagementsysproject25thFeb.models.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
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
public class CreateRequestStudent {


	private String name;

	private String phNum;

	@NotBlank
	@Email
	private String email;
	
	
	public User to() {
		return User.builder().name(name).ph(phNum).email(email).build();
		
	}

}
