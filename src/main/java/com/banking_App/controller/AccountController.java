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
import org.springframework.web.bind.annotation.RestController;

import com.banking_App.Exception.ResourcesNotFoundException;
import com.banking_App.Service.AccountService;
import com.banking_App.entity.Account;
import com.banking_App.entity.User;

@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@PostMapping("/{userId}")
	public ResponseEntity<Account> createAccount(  @PathVariable long userId, @RequestBody Account account){
		return new ResponseEntity<Account> (accountService.createAccount(userId, account),HttpStatus.OK);
	}
	
	@GetMapping("/{accountId}")
	public ResponseEntity<Account> getAccountById(@PathVariable long accountId) {
		return new ResponseEntity<Account>(accountService.getAccountById(accountId),HttpStatus.OK);
	}
	
	@DeleteMapping("/user/{userId}/account/{accountId}")
	public ResponseEntity<String> deleteAccountById(@PathVariable Long userId, @PathVariable Long accountId) {
		return new ResponseEntity<String>(accountService.deleteAccountById(userId, accountId),HttpStatus.OK);
		
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Account>> getAccountByUserId ( @PathVariable Long userId){
		return new ResponseEntity<List<Account>>(accountService.getAccountByUserId(userId),HttpStatus.OK);
	}
	
	@GetMapping("/getBalance/{accountId}")
	public ResponseEntity<Double> getAccountBalance(@PathVariable Long accountId) {
		return new ResponseEntity<Double>(accountService.getAccountBalance(accountId),HttpStatus.OK);
	}
	
	
	
}
