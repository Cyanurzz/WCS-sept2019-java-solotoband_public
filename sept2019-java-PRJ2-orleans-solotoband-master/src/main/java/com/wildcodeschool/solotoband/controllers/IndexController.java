package com.wildcodeschool.solotoband.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class IndexController {
	
	
	@GetMapping("/")
	public String start(Model model,@RequestParam(value = "error", required = false, defaultValue = "0") String error) {
		model.addAttribute("error",error);
    	return "Index";
	}
}
