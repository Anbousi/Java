package com.axsos.anbousi;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Controller
public class TestjspApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestjspApplication.class, args);
		
	}
	
@RequestMapping("/")
public String Index(){
return "index.jsp";
	}


	
}
