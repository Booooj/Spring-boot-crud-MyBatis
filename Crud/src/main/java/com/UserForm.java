package com.example;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import lombok.Data;

@Data
public class UserForm {

	@NotBlank
	@Email
	 private String id;
	
	@NotBlank
	@Length(min = 5)
	 private String password;
	
	@NotBlank
	 private String name;
}
