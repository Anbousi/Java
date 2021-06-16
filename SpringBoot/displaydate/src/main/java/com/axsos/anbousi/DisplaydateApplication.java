package com.axsos.anbousi;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class DisplaydateApplication {

	public static void main(String[] args) {
		SpringApplication.run(DisplaydateApplication.class, args);
	}
@Controller
public class Home{

	@RequestMapping("/")
	public String homePage() {
		
		return "index.jsp";
	}
	
	@RequestMapping("time")
	public String timePage(Model model) {
		Date time = new Date();
		SimpleDateFormat f = new SimpleDateFormat ("hh:mm a");
		model.addAttribute("time", f.format(time));
				return "time.jsp";
	}
	
	@RequestMapping("date")
	public String pagePage(Model model) {
		Date date = new Date();
		SimpleDateFormat date1 = new SimpleDateFormat("EEEE, 'the' dd 'of' MMMM, YYYY");
		model.addAttribute("date", date1.format(date));
		return "date.jsp";
	}
	
}


}
