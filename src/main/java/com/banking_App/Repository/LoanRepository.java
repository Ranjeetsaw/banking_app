package com.banking_App.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.banking_App.entity.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long>{

	
	@Query(value=" select l from Loan l where l.user.uid=?1")
	Loan getLoanByUserId(Long userId);
	
}
