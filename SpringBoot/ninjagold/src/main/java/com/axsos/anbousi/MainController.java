package com.axsos.anbousi;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
ArrayList <String> activities = new ArrayList<String>();

	@RequestMapping("/")
	public String home(HttpSession session) {
		if(session.getAttribute("total") == null) {
			session.setAttribute("total", 0);
		}
		if(session.getAttribute("activ") == null) {
			session.setAttribute("activ", "");
		}
		return "home.jsp";
	}
	
	
	@RequestMapping(value="/process_money", method=RequestMethod.POST)
	public String process(@RequestParam(value="money") String money, HttpSession session) {
		
		if(session.getAttribute("total") == null) {
			session.setAttribute("total", 0);
			session.setAttribute("gold", 0);
		}
		if(session.getAttribute("activ") == null) {
			session.setAttribute("activ", activities);
		}
		
		Random r = new Random();
		int gold;
		
		Date date = new Date();
		SimpleDateFormat date1 = new SimpleDateFormat("EEEE, MMMM dd YYYY hh:mm:ss a");
		String date2 = date1.format(date);
		

		if(money.equals("farm_gold")) {
			gold = r.nextInt(10)+10;
			session.setAttribute("total", +(gold + (int) session.getAttribute("total")));
			String s = "You entere  a farm and earned " + Integer.toString(gold) +" at " + date2;
			activities.add(s);
			session.setAttribute("gold", gold);
			session.setAttribute("activ", activities);
		}
		
		if(money.equals("cave_gold")) {
			gold = r.nextInt(5)+5 ;
			session.setAttribute("total", +(gold + (int) session.getAttribute("total")));
			
			String s = "You entere  a cave and earned " + Integer.toString(gold) +" at " + date2;
			activities.add(s);
			session.setAttribute("gold", gold);
			session.setAttribute("activ", activities);
		}
		
		if(money.equals("house_gold")) {
			gold = r.nextInt(3)+2 ;
			session.setAttribute("total", +(gold+ (int) session.getAttribute("total")));
			
			String s = "You entere  a house and earned " + Integer.toString(gold) +" at " + date2;
			activities.add(s);
			session.setAttribute("gold", gold);
			session.setAttribute("activ", activities);
		}
		
		if(money.equals("casino_gold")) {
			gold = r.nextInt(100)-50 ;
			session.setAttribute("total", +(gold + (int) session.getAttribute("total")));
			session.setAttribute("gold", gold);
			if(gold >= 0) {
						
				String s = "You entere  a casino and earned " + Integer.toString(gold) +" at " + date2;
				activities.add(s);
			}
			else{
				gold *= -1;
				session.setAttribute("gold", gold);
				String s = "You entere  a casino and lost " + Integer.toString(gold)  +" at " + date2;
				activities.add(s);
			}
			session.setAttribute("total", (gold + (int) session.getAttribute("total")));
			session.setAttribute("activ", activities);
		}
		return "redirect:/";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.removeAttribute("total");
		session.removeAttribute("activ");
		activities.clear();
		return "redirect:/";
		
	}
	
	
	
	

	

	
}
