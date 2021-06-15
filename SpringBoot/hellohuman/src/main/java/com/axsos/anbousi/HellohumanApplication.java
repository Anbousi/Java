package com.axsos.anbousi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@SpringBootApplication
@RestController


public class HellohumanApplication {

	public static void main(String[] args) {
		SpringApplication.run(HellohumanApplication.class, args);
	}
	
@RequestMapping("")
//3. Method that maps to the request route above
public String Hello(@RequestParam(value="name", required = false) String name , @RequestParam(value="last_name", required = false) String lname) { // 3
	if (name == null) {
		return "Hello Human";
	}
	else if (name.length() > 0) {
		
		if(lname == null) {
			return "Hello "+ name;
		}
		if (lname.length()>0) {
			return "Hello "+name + " " + lname;
		}
		return "Hello "+ name;
	}

	return "Hello Human";
	
}
}