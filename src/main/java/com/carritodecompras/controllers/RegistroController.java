package com.carritodecompras.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/carritodecompras")
public class RegistroController {

	@GetMapping(value = "/registro")
	public String iniciar() {
		return inicio;
	}
	
	private static final String inicio="inicio-registro/registro";
}
