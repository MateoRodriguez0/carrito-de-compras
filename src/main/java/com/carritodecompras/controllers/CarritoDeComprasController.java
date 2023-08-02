package com.carritodecompras.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/carritodecompras/elcarrito")
public class CarritoDeComprasController {
	

	@GetMapping(value = "/detalles/{idProducto}")
	public String Detalles(@PathVariable(name = "idProducto")Integer idproducto ) {
		
		return detalles;
	}
	
	private static final String detalles="vistasroductos/detalles";
}
 