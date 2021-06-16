package com.axsos.anbousi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Home {

	@RequestMapping("/")
	public String homePage() {
		return "home.jsp";
	}
	
	@RequestMapping(value="/code", method=RequestMethod.POST)
	public String trying(@RequestParam(value="try") String trying) {
		if(trying.equals("bushido")) {
			return "java.jsp";
		}
		
		return "redirect:/createError";
	}
	
	@RequestMapping("/createError")
    public String flashMessages(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("error", "You must train harder");
        return "redirect:/";
	
}
}
