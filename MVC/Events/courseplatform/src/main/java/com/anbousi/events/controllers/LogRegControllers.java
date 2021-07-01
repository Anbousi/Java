package com.anbousi.events.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.anbousi.events.models.Event;
import com.anbousi.events.models.State;
import com.anbousi.events.models.User;
import com.anbousi.events.models.UserEvent;
import com.anbousi.events.services.EventsServices;
import com.anbousi.events.validator.UserValidator;

@Controller
public class LogRegControllers {
	private final EventsServices appServices;
	private final UserValidator userValidator;

	public LogRegControllers(EventsServices appServices, UserValidator userValidator) {
		this.appServices = appServices;
		this.userValidator = userValidator;
	}

// Home Page, Login and Registration
	@RequestMapping("/")
	public String home(@ModelAttribute("user") User user, Model model, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			List<State> states = appServices.getAllStates();
			model.addAttribute("states", states);
			return "home.jsp";
		}
		return "redirect:/events";
	}

//	Register Form and Login Form
	@RequestMapping(value="/", method=RequestMethod.POST)
	 public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session,@RequestParam("check") String check,@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
		if(session.getAttribute("userId") != null){
			return ("redirect:/events");
		}
		if(check.equals("login")) {			
			boolean isAuth = appServices.authenticateUser(email, password);
			if (isAuth) {
				User u = appServices.findByEmail(email);
				session.setAttribute("userId", u.getId());
				return "redirect:/events";
			}
				
			model.addAttribute("Error1", "Email or Password is incorrect");
			System.out.println(model.getAttribute("Error1"));
			user.setEmail(null);user.setPassword(null);
			List<State> states = appServices.getAllStates();
			model.addAttribute("states", states);
			 return "home.jsp";
		}
		
		List<State> states = appServices.getAllStates();
		model.addAttribute("states", states);
		
		if(check.equals("register")) {
		 try {
			 userValidator.validate(user, result);
		     if(result.hasErrors()) {

		         return "home.jsp";
		     }
		     
		     User u = appServices.registerUser(user);
		     session.setAttribute("userId", u.getId());
		     return "redirect:/events";		 
		 }
		 catch(Exception e) {
			 model.addAttribute("Error", "This email is already used");
		 }

		 return "home.jsp";
		}

		 return "home.jsp";
}
	
// Events Page, Welcome page
	@RequestMapping("/events")
	public String events(@ModelAttribute("event") Event event, Model model, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		User u = appServices.findUserById((Long) session.getAttribute("userId"));
		model.addAttribute("user",u);
		List<State> states = appServices.getAllStates();
		model.addAttribute("states", states);
		List<Event> events = appServices.findAllEvents();
		model.addAttribute("events", events);
		List<UserEvent> ue = appServices.getAllUserEvent();
		model.addAttribute("AllUserEvent", ue);
		return "events.jsp";
	}
	
	@RequestMapping(value="/events" ,  method=RequestMethod.POST )
	public String createEvent(@Valid @ModelAttribute("event") Event event,BindingResult result, Model model, HttpSession session) {
		if(result.hasErrors()) {
			System.out.println("error occured");
			User u = appServices.findUserById((Long) session.getAttribute("userId"));
			model.addAttribute("user",u);
			List<State> states = appServices.getAllStates();
			model.addAttribute("states", states);
			List<Event> events = appServices.findAllEvents();
			model.addAttribute("events", events);
			model.addAttribute("er", result);
	         return "events.jsp";
	     }
		Long userId = (Long) session.getAttribute("userId");
		User u = appServices.findUserById(userId);
		Event e = appServices.createEvent(userId,event);
		
		return "redirect:/events";
	}
	
//Logout
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
			return "redirect:/";
	}
	
//Add States
	@RequestMapping("/addstates")
	public String statePage(@ModelAttribute("state") State state ) {
			return "addState.jsp";
	}
	
	@RequestMapping(value="/addstates", method=RequestMethod.POST)
	public String addState(@Valid @ModelAttribute("state") State state ,BindingResult result,Model model ) {
		if(result.hasErrors()) {
	         return "addState.jsp";
	     }
		try {
		appServices.addState(state);
		}
		catch(Exception e){
			model.addAttribute("error", "This state is already added");
			return "addState.jsp";
		}
			return "redirect:/addstates";
	}
	
	
	@RequestMapping(value="/events/join/{id}")
    public String joinEvent(Model model,@PathVariable("id") Long eventId, HttpSession session) {
		Long userId= (Long) session.getAttribute("userId");
		appServices.userEvent(eventId,userId);
		System.out.println(eventId);
		System.out.println(userId);
        return "redirect:/events";
    }
	
	@RequestMapping(value="/events/cancel/{id}")
    public String cancelEvent(Model model,@PathVariable("id") Long eventId, HttpSession session) {
		Long userId= (Long) session.getAttribute("userId");
		appServices.userEventCancel(eventId,userId);
        return "redirect:/events";
    }
	


}

