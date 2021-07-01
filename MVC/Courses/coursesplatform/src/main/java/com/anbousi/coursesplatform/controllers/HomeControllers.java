package com.anbousi.coursesplatform.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.anbousi.coursesplatform.models.User;
import com.anbousi.coursesplatform.services.AppServices;
import com.anbousi.coursesplatform.valodator.UserValidator;

@Controller
public class HomeControllers {
	
	private final AppServices appServices;
	private final UserValidator userValidator;
	
	public HomeControllers(AppServices appServices, UserValidator userValidator) {
		this.appServices = appServices;
		this.userValidator = userValidator;
	}
	
// Home Page, Login and Registration
	@RequestMapping("/")
	public String home(@ModelAttribute("user") User user, Model model, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "home.jsp";
		}
		return "redirect:/courses";
	}

//		Register Form and Login Form
		@RequestMapping(value="/", method=RequestMethod.POST)
		 public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session,@RequestParam("check") String check,@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
			if(session.getAttribute("userId") != null){
				return ("redirect:/courses");
			}
			if(check.equals("login")) {			
				boolean isAuth = appServices.authenticateUser(email, password);
				if (isAuth) {
					User u = appServices.findByEmail(email);
					session.setAttribute("userId", u.getId());
					return "redirect:/courses";
				}
					
				model.addAttribute("Error1", "Email or Password is incorrect");
				System.out.println(model.getAttribute("Error1"));
				user.setEmail(null);
				user.setPassword(null);
				 return "home.jsp";
			}
						
			if(check.equals("register")) {
			 try {
				 userValidator.validate(user, result);
			     if(result.hasErrors()) {

			         return "home.jsp";
			     }
			     
			     User u = appServices.registerUser(user);
			     session.setAttribute("userId", u.getId());
			     return "redirect:/courses";		 
			 }
			 catch(Exception e) {
				 model.addAttribute("Error", "This email is already used");
			 }

			 return "home.jsp";
			}

			 return "home.jsp";
	}
		
//Logout----------------------------------------------------------
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
			return "redirect:/";
	}
	
	

}

