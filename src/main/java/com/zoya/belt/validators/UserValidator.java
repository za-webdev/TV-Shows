package com.zoya.belt.validators;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.zoya.belt.models.User;
import com.zoya.belt.services.UserService;


@Component
public class UserValidator {
	
	private UserService userService;
	private BCryptPasswordEncoder bcrypt;
	
	public UserValidator(UserService userService,BCryptPasswordEncoder bcrypt) {
		this.userService=userService;
		this.bcrypt=bcrypt;
	}
	
	

	public static Pattern EMAIL_REGEX = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]+");
	
	public HashMap<String,Object> register(Map<String,String> body){
		HashMap<String,Object> results= new HashMap<String,Object>();
		
		//user name validations
		if(body.get("username").length()<3) {
			results.put("username", "Username must be 3 characters or long");
		}
		
		//email validations
		if(body.get("email").length()<1) {
			results.put("email", "Email is required");
		}
		else if (!EMAIL_REGEX.matcher(body.get("email")).matches()) {
			results.put("email", "Invalid Email");
		}
		else if(userService.findByEmail(body.get("email")) != null) {
			results.put("email", "Email already in use!");
		}
		
		//password  validations
		if(body.get("password").length()<8) {
			results.put("password", "Password must be 8 characters or longer");
		}
		
		//confirm pass validations
		if(!body.get("confirm").equals(body.get("password"))) {
			results.put("confirm", "Confirm password must match password");
		}
		
		results.put("valid", results.size()==0);
		
		
		return results;
	}
	
	public User login (Map<String,String>body) {
		 
		Boolean valid =true;
		User user =new User();
		
		if(body.get("email").length()<1) {
			valid= false;
		}
		else if (!EMAIL_REGEX.matcher(body.get("email")).matches()) {
			valid= false;
		}
		
		else {
			System.out.println(userService);
			System.out.println(body);
			user= userService.findByEmail(body.get("email"));
			
			if (user == null) {
				valid = false;
			}
		}
		
		//password  validations
		if(body.get("password").length()<8) {
			valid= false;
		}
		else {
			if(valid) {
				if(!bcrypt.matches(body.get("password"), user.getPassword())) {
					valid=false;
				}	
			}
		}
		
		return valid ? user:null;
	}
}

