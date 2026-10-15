package com.banking_App.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking_App.Exception.ResourcesNotFoundException;
import com.banking_App.Repository.AccountRepository;
import com.banking_App.Repository.UserRepository;
import com.banking_App.entity.Account;
import com.banking_App.entity.User;

@Service
public class AccountService {

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	
	public Account createAccount(long userId,Account account) {
		User u=userRepository.findById(userId)
				.orElseThrow(()->new ResourcesNotFoundException("User","user Id",userId));
		
		u.addAccount(account);
		return accountRepository.save(account);	
		
	}
	
	
	public Account getAccountById(long accountId) {
		return accountRepository.findById(accountId).orElseThrow(()->new ResourcesNotFoundException("Account", "AccountId", accountId));
	}
	
	public String deleteAccountById( Long userId,Long accountId) {
		User u=userRepository.findById(userId).orElseThrow(()->new ResourcesNotFoundException("User", "User Id", userId));
		Account a=accountRepository.findById(accountId).orElseThrow(()->new ResourcesNotFoundException("Account", "Account Id", accountId));
		u.removeAccount(a);
		userRepository.save(u);
		return "data deleted";
		
	}
	
	
	public List<Account > getAccountByUserId(Long userId){
		return accountRepository.findByUserUid(userId);
	}
	
	public double getAccountBalance(Long accountId) {
		Account a=accountRepository.findById(accountId).orElseThrow(()->new ResourcesNotFoundException("Account", "Account Id", accountId));
		return a.getBalance();
	}
	
	
	
	
	
}
