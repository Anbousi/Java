package com.anbousi.driver.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.anbousi.driver.models.License;
import com.anbousi.driver.models.Person;
import com.anbousi.driver.services.DriverLicenseServices;


@Controller
public class DriverControllers {
	
	private final DriverLicenseServices appServices;

	public DriverControllers(DriverLicenseServices driverServices) {
		this.appServices = driverServices;
	}
	
	@RequestMapping("/")
	public String home(Model model) {
		return "home.jsp";
	}
	
	@RequestMapping("/add_person")
	public String addPerson(Model model,@ModelAttribute("person") Person person) {
		return "addPerson.jsp";
	}

	@RequestMapping(value="/add_person", method=RequestMethod.POST)
	public String createPerson(Model model,@Valid @ModelAttribute("person") Person person , BindingResult result) {
		if (result.hasErrors()) {
            return "addPerson.jsp";
        } else {
        	appServices.createPerson(person);
            return "redirect:/";
        }
	}
		
		
	@RequestMapping(value="/persons/{id}")
	public String showPerson(Model model,@PathVariable("id") Long id) {
		Person person = appServices.findPerson(id);
		Date date = person.getLicense().getExpirationDate();
		DateFormat f = new SimpleDateFormat ("yyyy-MM-dd");
		model.addAttribute("date", f.format(date));
		model.addAttribute("person",person);
		return "show.jsp";
		
	}
	
	@RequestMapping(value="/show_all")
	public String showAllPerson(Model model) {
		List<Person> persons = appServices.findAllPersons();
		model.addAttribute("persons",persons);
		return "index.jsp";
		
	}

}
