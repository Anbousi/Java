package com.anbousi.driver.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.anbousi.driver.models.License;
import com.anbousi.driver.models.Person;
import com.anbousi.driver.services.DriverLicenseServices;

@Controller
public class LicenseControllers {
	private final DriverLicenseServices appServices;

	public LicenseControllers(DriverLicenseServices licenseServices) {
		this.appServices = licenseServices;
	}
	
	
	@RequestMapping("/add_license")
	public String addLicense(Model model,@ModelAttribute("license") License license) {
        List<Person> persons = appServices.allPersonsWithNoLicenses();
        model.addAttribute("persons", persons);
		return "addLicense.jsp";
	}
	
	
	@RequestMapping(value="/add_license", method=RequestMethod.POST)
	public String createLicense(Model model,@Valid @ModelAttribute("license") License license , BindingResult result) {
		if (result.hasErrors()) {
            return "addLicense.jsp";
        } else {
        	appServices.createLicense(license);
            return "redirect:/";
        }
		
	}
}
