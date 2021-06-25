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
import com.anbousi.dojoninjas.models.Ninja;
import com.anbousi.dojoninjas.services.DojoNinjasServices;

@Controller
public class NinjasControllers {
	private final DojoNinjasServices appServices;

	public NinjasControllers(DojoNinjasServices appServices) {
		this.appServices = appServices;
	}
	
	
//	Add a ninja page
	@RequestMapping(value="/ninjas/new")
    public String ninjaPage(Model model, @ModelAttribute("ninja") Ninja ninja) {
		List<Dojo> allDojos = appServices.findAllDojos();
		model.addAttribute("dojos", allDojos);
        return "ninja.jsp";
    }
	
//	Create a new Ninja method
	@RequestMapping(value="/ninjas/new", method=RequestMethod.POST)
    public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if (result.hasErrors()) {
            return "ninja.jsp";
        } else {
        	appServices.createNinja(ninja);
            return "redirect:/";
        }
    }
	
//	Delete Ninja
	@RequestMapping(value="/ninjas/delete/{id}")
    public String deleteNinjaById(@PathVariable("id") Long id) {
		appServices.deleteNinjaById(id);
        return "redirect:/";
    }

}
