package com.carritodecompras.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/carritodecompras")
public class HomeController {

	@GetMapping(value = "/")
	public String getHome() {
		
		return home;
	}
	
	
	private static final String home="principal/home";
}
