package com.banking_App.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking_App.Exception.ResourcesAlreadyExistsException;
import com.banking_App.Exception.ResourcesNotFoundException;
import com.banking_App.Repository.UserRepository;
import com.banking_App.entity.User;

@Service
public class UserService {
	
	@Autowired
private UserRepository userRepository;

public User saveUser(User user) {
	boolean isEmailPresent=userRepository.existsByEmail(user.getEmail());
	boolean isPhonePresent =userRepository.existsByPhone(user.getPhone());
	
	if(isEmailPresent) {
		throw new ResourcesAlreadyExistsException(user.getEmail());
		
	}
	if(isPhonePresent) {
		throw new ResourcesAlreadyExistsException(String.valueOf(user.getPhone()));
	}
	return userRepository.save(user);	
}


public User getUserById(long id) {
	return userRepository.findById(id).orElseThrow(()-> new ResourcesNotFoundException("User","Id" ,id));
}

public List<User> getAll(){
	return userRepository.findAll();
}
	
public String deleteUserById(long id) {
	
	User u=userRepository.findById(id).orElseThrow(()->new ResourcesNotFoundException("User","Id",id));
	userRepository.delete(u);
	return "user data deleted";
}

public User getUserByEmail(String email) {
	return userRepository.findByEmail(email).orElseThrow(()-> new ResourcesNotFoundException("User","email" ,email));
}
	
}
