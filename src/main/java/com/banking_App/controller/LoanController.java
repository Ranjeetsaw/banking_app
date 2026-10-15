package com.banking_App.controller;

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
import com.banking_App.Service.LoanService;
import com.banking_App.entity.Loan;
import com.banking_App.entity.User;

@RestController
public class LoanController {

	@Autowired
	private LoanService loanService;
	
	@PostMapping("/{userId}/loans")
	public ResponseEntity<Loan> applyLoan(@PathVariable long userId,@RequestBody Loan l){
		return new ResponseEntity<Loan>(loanService.applyLoan(userId,l),HttpStatus.CREATED);
	}
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Loan> getLoanById( @PathVariable long id) {
		return new ResponseEntity<Loan> (loanService.getLoanById(id),HttpStatus.OK);
	}

	@DeleteMapping("/user/{userId}/loan/{loanId}")
	public ResponseEntity<String> deleteLoanById(long userId,long loanId) {
		return new ResponseEntity<String> (loanService.deleteLoanById(userId, loanId),HttpStatus.OK);
	}
	
	@GetMapping("/user/loan/{userId}")
	public ResponseEntity<Loan> getLoanByUserId( @PathVariable Long userId) {
		return  new ResponseEntity<Loan>(loanService.getLoanByUserId(userId),HttpStatus.OK);
	}
	
	@GetMapping("/status/{loanId}")
	public ResponseEntity<String> getLoanStatus(@PathVariable long loanId) {
		return new ResponseEntity<String>(loanService.getLoanStatus(loanId),HttpStatus.OK);
	}
	
	
	
	
	
	
}
