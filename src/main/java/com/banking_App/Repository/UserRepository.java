package com.banking_App.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking_App.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	//findById(long id);
	boolean existsByEmail(String email);
	boolean existsByPhone(long phone);
	Optional<User> findByEmail(String email);
}
