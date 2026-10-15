package com.banking_App.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking_App.Exception.ResourcesNotFoundException;
import com.banking_App.Repository.LoanRepository;
import com.banking_App.Repository.UserRepository;
import com.banking_App.entity.Loan;
import com.banking_App.entity.User;

@Service
public class LoanService {
	
	@Autowired
	private LoanRepository loanRepository;
	
	@Autowired
	private UserRepository userRepository;

	public  Loan applyLoan(long userId, Loan l) {
		
		return null;
	}
	
	
	public Loan getLoanById(long id) {
		return loanRepository.findById(id).orElseThrow(()->new ResourcesNotFoundException("Loan","Loan id",id));
	}

	public String deleteLoanById(long userId,long loanId) {
		User user=userRepository.findById(userId).orElseThrow(()->new ResourcesNotFoundException("User", "user id", userId));
		
		Loan l=loanRepository.findById(loanId).orElseThrow(()->new ResourcesNotFoundException("Loan","Loan id", loanId));
		
		user.removeLoan(l);
		userRepository.save(user);
		
		return "loan data deleted";
	}
	
	
	public Loan getLoanByUserId(Long userId) {
		return loanRepository.getLoanByUserId(userId);
	}
	
	public String getLoanStatus(long loanId) {
		Loan l=loanRepository.findById(loanId).orElseThrow(()->new ResourcesNotFoundException("Loan", "Loan Id", loanId));
		return l.getStatus();
	}
	
	
	
	
	
}
