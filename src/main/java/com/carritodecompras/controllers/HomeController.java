package com.carritodecompras.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * controlador de vista principal. 
 * 
 * 
 *@author Mateo j. Rodriguez Chico
 *
 *@since 1.0
 *
 */

@Controller
@RequestMapping(value = "/carritodecompras")
public class HomeController {

	/**
	 * devuelve la ubicacion del archivo en el que se encuentra la pagina principal.
	 * 
	 * @return la pagina principal.
	 */
	@GetMapping(value = "/")
	public String getHome() {
		
		return home;
	}
	
	
	
	/**
	 *  Es la ruta del archivo en el que se encuentra la pagina principal.
	 * 
	 */
	private static final String home="principal/home";
}
