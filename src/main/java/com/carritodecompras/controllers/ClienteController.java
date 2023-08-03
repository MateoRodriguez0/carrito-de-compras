package com.carritodecompras.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.carritodecompras.vendedor.services.ProductosVendedorService;

@Controller
@RequestMapping(value = "/carritodecompras/cliente")
public class ClienteController {

	@GetMapping( value = "/")
	public String principal(Model model) {;
		model.addAttribute("productos", productosVendedorService.getProductos());
		return principal;
	}
	
	@GetMapping( value = "/elcarrito")
	public String alCarrito(Model model) {;
		
		return carrito;
	}
	
	
	
	
	
	private static final String principal="vistascompradores/principal";
	private static final String carrito="vistascompradores/carrito";
	
	@Autowired
	private ProductosVendedorService productosVendedorService;
	
	
	
	
}
