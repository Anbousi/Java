package com.anbousi.lookify.controllers;

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

import com.anbousi.lookify.models.Lookify;
import com.anbousi.lookify.services.LookifyService;

@Controller
public class LookifyController {

	private final LookifyService lookifyService;

	public LookifyController(LookifyService lookifyService) {
		this.lookifyService = lookifyService;
	}

//	Home Page
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}

//	Show all Lookifies
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String index(Model model, @ModelAttribute("lookify") Lookify lookify) {
		List<Lookify> lookifies = lookifyService.allLookifies();
		model.addAttribute("lookifies", lookifies);
		return "show.jsp";
	}

//	New Song Form Page
	@RequestMapping(value = "/songs/new")
	public String newSong(Model model, @ModelAttribute("lookify") Lookify lookify) {
		return "new.jsp";
	}

//	Create new song method
	@RequestMapping(value = "/songs/new", method = RequestMethod.POST)
	public String createSong(Model model, @Valid @ModelAttribute("lookify") Lookify lookify, BindingResult result) {
		if (result.hasErrors()) {
			return "new.jsp";
		} else {
			lookifyService.createLookify(lookify);
			return "redirect:/dashboard";
		}
	}

//	Show a song info.
	@RequestMapping(value = "/songs/{id}")
	public String songInfo(Model model, @PathVariable("id") Long id) {
		System.out.println("Show info");
		Lookify lookify = lookifyService.findLookifyById(id);
		model.addAttribute("lookify", lookify);
		return "info.jsp";
	}

//	Delete Song
	@RequestMapping(value = "/dashboard/delete/{id}")
	public String deleteSong(@PathVariable("id") Long id) {
		lookifyService.deleteLookifyById(id);
		return "redirect:/dashboard";
	}
	
//	Search By Artist
	@RequestMapping(value="/search/", method=RequestMethod.POST)
    public String searchByArtist(Model model, @RequestParam("artist") String artist , @ModelAttribute("lookify") Lookify lookify) {
		List<Lookify> lookifies = this.lookifyService.searchSongByArtist(artist);
		model.addAttribute("lookifies", lookifies);
        return "search.jsp";
    }
	
//	Top Ten 
	@RequestMapping(value="/search/topTen")
    public String topTen(Model model, @ModelAttribute("lookify") Lookify lookify) {
		List<Lookify> lookifies = this.lookifyService.topTenByRate();
		model.addAttribute("lookifies", lookifies);
        return "show.jsp";
    }
	
	
}



