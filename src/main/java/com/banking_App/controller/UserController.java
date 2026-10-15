package com.banking_App.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking_App.Service.UserService;
import com.banking_App.entity.User;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody  User user){
		return new ResponseEntity<User>(userService.saveUser(user),HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id){
		return new  ResponseEntity<User> (userService.getUserById(id),HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<User>>  getAll(){
		return new ResponseEntity<List<User>>(userService.getAll(),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUserById( @PathVariable long id){
		return new ResponseEntity<String> (userService.deleteUserById(id),HttpStatus.OK);
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<User> getUserByEmail(@PathVariable String email){
		return new ResponseEntity<User> (userService.getUserByEmail(email),HttpStatus.OK);
	}
	
	
	
	

}