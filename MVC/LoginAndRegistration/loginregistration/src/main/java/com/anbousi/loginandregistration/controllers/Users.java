package com.anbousi.loginandregistration.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.anbousi.loginandregistration.models.User;
import com.anbousi.loginandregistration.services.UserService;
import com.anbousi.loginandregistration.validator.UserValidator;

@Controller
public class Users {
 private final UserService userService;
 private final UserValidator userValidator;
 

 
 public Users(UserService userService, UserValidator userValidator) {
	this.userService = userService;
	this.userValidator = userValidator;
}

@RequestMapping("/registration")
 public String registerForm(@ModelAttribute("user") User user, HttpSession session) {
	 if(session.getAttribute("id") == null ) {
		 return "registrationPage.jsp";
	 }
	 return "redirect:/home";
 }
 
 @RequestMapping("/login")
 public String login(HttpSession session) {
	 if(session.getAttribute("id") == null ) {
		 return "loginPage.jsp";
	 }
	 return "redirect:/home";
    
 }
 
 @RequestMapping(value="/registration", method=RequestMethod.POST)
 public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session,Model model) {
     // if result has errors, return the registration page (don't worry about validations just now)
     // else, save the user in the database, save the user id in session, and redirect them to the /home route
	 
//	 if(user.getPassword().equals(user.getPasswordConfirmation())) {
//		 if (result.hasErrors()) {
//	         return "registrationPage.jsp";
//	     }
//	 userService.registerUser(user);
//	 session.setAttribute("id", user.getId());
//	 return "redirect:/home";
//	 }
//	 return "registrationPage.jsp";
	 try {
		 userValidator.validate(user, result);
	     if(result.hasErrors()) {
	         return "registrationPage.jsp";
	     }
	     User u = userService.registerUser(user);
	     session.setAttribute("userId", u.getId());
	     return "redirect:/home";		 
	 }
	 catch(Exception e) {
		 model.addAttribute("Error", "This email is aleady used");
	 }
	 return "registrationPage.jsp";
 }
	 
	 
 
 @RequestMapping(value="/login", method=RequestMethod.POST)
 public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
     // if the user is authenticated, save their user id in session
     // else, add error messages and return the login page
	 boolean isAuth = userService.authenticateUser(email, password);
	 if(isAuth) {
		 User user = userService.findByEmail(email);
		 session.setAttribute("id", user.getId());
		 return "redirect:/home";
	 }
	 return "loginPage.jsp";
 }
// 
 @RequestMapping("/home")
 public String home(HttpSession session, Model model) {
	 if(session.getAttribute("id") == null ) {
		 return "redirect:/login";
	 }
     // get user from session, save them in the model and return the home page
	 Long id = (Long) session.getAttribute("id");
	 User user = userService.findUserById(id);
	 model.addAttribute("user", user);
	 return "homePage.jsp";
	 
 }
 @RequestMapping("/logout")
 public String logout(HttpSession session) {
     // invalidate session
     // redirect to login page
	 session.invalidate();
	 return "redirect:/login";
 }
}
