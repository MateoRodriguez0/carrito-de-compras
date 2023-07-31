package com.carritodecompras.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/carritodecompras")
public class LoginController {

	@GetMapping(value = "/inicio")
	public String registrar() {
		return registrar;
	}
	
	private static final String registrar="inicio-registro/inicio";

	
}
