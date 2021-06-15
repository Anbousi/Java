package com.axsos.anbousi;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dojo")
public class DojoController {
	
@RequestMapping("")
	public String hello() { // 3
	    return "The dojo is awesome";
	}

@RequestMapping("/{bixy}")
public String showBixy(@PathVariable("bixy") String bixy){
	if(bixy.equals("burbank-dojo"))
		return "Burbank Dojo is located in Southern California";
	if(bixy.equals("san-jose"))
		return "SJ dojo is the headquarters";
	return null;
}

}

