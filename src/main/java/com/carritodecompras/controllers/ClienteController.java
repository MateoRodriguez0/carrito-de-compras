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
	
	@GetMapping( value = "/producto/detalles")
	public String detallesdelProducto(Model model) {;
		
		return vistadetallesProducto;
	}
	@GetMapping( value = "/producto/informacion")
	public String informaciondelProducto(Model model) {;
		
		return vistainformacionProducto;
	}
	
	@GetMapping( value = "/producto/agregar")
	public String vistaAgregarAlCarrito(Model model) {;
		
		return vistaagregaralcarrito;
	}
	
	@GetMapping( value = "/producto/actualizar")
	public String vistaActualizar(Model model) {;
		
		return vistaactualizar;
	}
	
	
	
	
	
	private static final String principal="vistascompradores/principal";
	private static final String vistaagregaralcarrito="vistascompradores/agregaralcarrito";
	private static final String vistaactualizar="vistascompradores/actualizar";
	private static final String carrito="vistascompradores/carrito";
	private static final String vistadetallesProducto="vistascompradores/detallesproducto";
	private static final String vistainformacionProducto="vistascompradores/informacionproducto";
	
	@Autowired
	private ProductosVendedorService productosVendedorService;
	
	
	
	
}
