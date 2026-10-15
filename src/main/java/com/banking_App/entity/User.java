package com.banking_App.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long uid;
	private String name;
	private String email;
	private long phone;
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL,orphanRemoval = true)
	private List<Loan> loans;
	
	public void addLoan(Loan l) {
		loans.add(l);
		l.setUser(this);
	}
	
	public void removeLoan(Loan l) {
		loans.remove(l);
		l.setUser(null);
	}
	
	
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Account> accounts;


	public void addAccount(Account account) {
	    accounts.add(account);
	    account.setUser(this);
	}

	public void removeAccount(Account account) {
	    accounts.remove(account);
	    account.setUser(null);
	}
	
}
	
	
	
	