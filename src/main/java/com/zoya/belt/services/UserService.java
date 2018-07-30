package com.zoya.belt.services;

import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.zoya.belt.models.User;
import com.zoya.belt.repositories.UserRepository;

@Service
public class UserService {
	
	private BCryptPasswordEncoder bcrypt;
	private UserRepository userRepository;
	
	public UserService(UserRepository userRepository,BCryptPasswordEncoder bcrypt) {
		this.userRepository=userRepository;
		this.bcrypt=bcrypt;
	}
	
	public User create(Map <String,String> body) {
		return userRepository.save(new User(
				body.get("username"),
				body.get("email"),
				bcrypt.encode(body.get("password"))
				
		));
	}
	
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	
}
