package com.banking_App.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Loan {
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private double amount;
	private LocalDateTime apply;
	private LocalDateTime approveDate;
	private LocalDateTime disbursementDate;
	private double balance;
	private String status;
	                               
	@ManyToOne
	@JoinColumn(name="user_id")
	@JsonBackReference
	private User user;
	
	
}
