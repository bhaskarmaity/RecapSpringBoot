package com.org.RecapSpringBoot.User;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class User {
	private Integer id;
	@Size(min=3,max=10,message="Name should have within 2-10 characters")
	private String name;
	@Past
	private Date birthDate;
}