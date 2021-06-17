package com.axsos.anbousi;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String home(HttpSession session) {
		session.setAttribute("name", null);
		session.setAttribute("location", null);
		session.setAttribute("language", null);
		session.setAttribute("comment", null);
		
		return "home.jsp";
	}
	

	@RequestMapping(value="/data", method=RequestMethod.POST)
	public String data(@RequestParam(value="name") String name, @RequestParam(value="location") String location ,  @RequestParam(value="language") String language , @RequestParam(value="comment" , required=false) String comment , HttpSession session ) {
		
			if(session.getAttribute("name") == null) {
			session.setAttribute("name", name);
			session.setAttribute("location", location);
			session.setAttribute("language", language);
			if(comment != null) {
			session.setAttribute("comment", comment);
			}
			}
		return "redirect:/result";
	
	}
	

	
	
	@RequestMapping("/result")
	public String result() {
		return "result.jsp"; 
	}

}
