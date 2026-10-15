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
@Setter
@Getter
public class Transaction {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long tid;
	private double amount;
	private LocalDateTime date;
	private String type;
	
	@ManyToOne
	@JoinColumn
	@JsonBackReference
	private Account account;
}
