package com.org.RecapSpringBoot.User;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.validation.Valid;


@RestController
public class UserResource {
	
	@Autowired
	UserDAOService userDAOService;
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return userDAOService.findAll();
	}

	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id)	{
		User user=userDAOService.findUser(id);
		if(user!=null)
			return user;
		else 
			throw new UserNotFoundException("Id : "+id+" is notFound");		
	}
	
	@PostMapping("/adduser")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user)	{
		User savedUser=userDAOService.save(user); 
		if(savedUser!=null) {
			URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
			return ResponseEntity.created(location).build();
		}
		else 
			 return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id)	{
		User user=userDAOService.deleteUserById(id);
		if(user==null)
			throw new UserNotFoundException("Id : "+id+" is notFound");
	}
}