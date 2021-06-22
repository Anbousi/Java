package com.anbousi.languages.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.anbousi.languages.models.Language;
import com.anbousi.languages.services.LangServices;

@Controller
public class LangController {
	
	private final LangServices langService;
	
	public LangController(LangServices langService) {
		this.langService = langService;
	}
	
//	Home page , show all languages
	@RequestMapping(value="languages", method=RequestMethod.GET)
    public String index(Model model, @ModelAttribute("language") Language lang) {
        List<Language> languages = langService.allLanguages();
        model.addAttribute("languages", languages);
        return "/languages/index.jsp";
    }
	
//	Create a new language
	@RequestMapping(value="languages", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("language") Language lang, BindingResult result, Model model) {
        if (result.hasErrors()) {
        	List<Language> languages = langService.allLanguages();
            model.addAttribute("languages", languages);
            return "/languages/index.jsp";
        } else {
        	langService.createLanguage(lang);
            return "redirect:/languages";
        }

	}
	
//	Show specific language info
	@RequestMapping(value="/languages/{id}" , method=RequestMethod.GET)
    public String show(@PathVariable("id") Long id , Model model) {
		Language language = langService.findLanguageById(id);
        model.addAttribute("language", language);
        return "/languages/info.jsp";
    }
	
//	@RequestMapping(value="languages/new", method=RequestMethod.POST)
//    public String newLanguage(@RequestParam(value="name") String name,@RequestParam(value="creator") String creator,@RequestParam(value="version") double version  ) {
//		langService.createLanguage(name,creator,version);
//        return "redirect:/languages";
//    }
	
//	Edit language 
	@RequestMapping(value="/languages/{id}/edit" , method=RequestMethod.GET)
    public String edit(@PathVariable("id") Long id , Model model) {
        Language language = langService.findLanguageById(id);
        System.out.println(language.getName());
        model.addAttribute("language", language);
        return "/languages/edit.jsp";
    }
    
//	Delete language
	@RequestMapping(value="languages/{id}" , method=RequestMethod.DELETE)
    public String delete(@PathVariable("id") Long id) {
		langService.deleteLanguage(id);
        return "redirect:/languages";
        }

	

	
//	Update language
	@RequestMapping(value="languages/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("language") Language lang, BindingResult result, Model model , @PathVariable("id") Long id , @RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="version") double version) {
        if (result.hasErrors()) {
        	List<Language> languages = langService.allLanguages();
            model.addAttribute("languages", languages);
            return "/languages/edit.jsp";
        } else {
        	langService.updateLanguage(id , name , creator , version);
            return "redirect:/languages";
        }
	}
	
	
	
	
	
	
	
	
}
