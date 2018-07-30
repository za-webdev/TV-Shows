package com.zoya.belt.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zoya.belt.models.User;
import com.zoya.belt.services.UserService;
import com.zoya.belt.validators.UserValidator;


@Controller
public class Users {
	
	private UserValidator userValidator;
	private UserService userService;
	
	public Users(UserValidator userValidator,UserService userService) {
		this.userValidator=userValidator;
		this.userService=userService;
	}
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@PostMapping("/register")
	public String register(@RequestParam Map <String,String> body,RedirectAttributes flash,HttpSession session) {
		HashMap<String,Object> results = userValidator.register(body);
		if((boolean) results.get("valid")) {
			session.setAttribute("user", userService.create(body));
		}
		else {
			flash.addFlashAttribute("errors", results);
			return "redirect:/";
		}
	
		return "redirect:/dashboard";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam Map <String,String> body,RedirectAttributes flash,HttpSession session) {
		User user = userValidator.login(body);
		if(user !=null){
			session.setAttribute("user", user);
			flash.addFlashAttribute("msg",String.format("welcome back: %s!",user.getUsername()));
		}
		else {
			flash.addFlashAttribute("loginErr","Invalid credentials");
			return "redirect:/";
		}
	
		return "redirect:/dashboard";
	}
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}	
