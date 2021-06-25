package com.anbousi.dojoninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.anbousi.dojoninjas.models.Dojo;
import com.anbousi.dojoninjas.services.DojoNinjasServices;

@Controller
public class DojoControllers {
	
	private final DojoNinjasServices appServices;

	public DojoControllers(DojoNinjasServices appServices) {
		this.appServices = appServices;
	}
	
	@RequestMapping("/")
	public String homePage(Model model) {
		List<Dojo> allDojos = appServices.findAllDojos();
		model.addAttribute("dojos" , allDojos);
		return "home.jsp";
		
	}
	
	
//	Add a dojo page
	@RequestMapping(value="/dojos/new")
    public String dogoPage( @ModelAttribute("dojo") Dojo dojo) {
        return "dojo.jsp";
    }
	
//	Create a new Dojo method
	@RequestMapping(value="/dojos/new", method=RequestMethod.POST)
    public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
            return "dojo.jsp";
        } else {
        	appServices.createDojo(dojo);
            return "redirect:/";
        }
    }
	
//	Delete Dojo
	@RequestMapping(value="/dojos/delete/{id}")
    public String deleteDojo(@PathVariable("id") Long id) {
		appServices.deleteDojoById(id);
        return "redirect:/";
    }
	
// Show Dojo's Ninja
	@RequestMapping("/dojos/{id}")
	public String showDojosNinjas(@PathVariable("id") Long id , Model model) {
		Dojo dojo = appServices.findDojoById(id);
		model.addAttribute("dojo" , dojo);
		System.out.println(dojo);
		return ("showDojoNinja.jsp");
	}
	
	

}
