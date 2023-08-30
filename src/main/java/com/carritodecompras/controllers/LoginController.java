package com.carritodecompras.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.carritodecompras.model.Usuario;
import com.carritodecompras.servicies.RolServices;

import jakarta.validation.Valid;

/**
 * controlador de pagina de incio de sesion 
 * 
 *@author Mateo j. Rodriguez Chico
 *
 *@since 1.0
 *
 */

@Controller
@RequestMapping(value = "/carritodecompras")
public class LoginController {

	/**
	 * devuelve la ubicacion del archivo en el que se encuentra la pagina de inicio de sesion.
	 * 
	 * @return la pagina de incio.
	 */
	@GetMapping(value = "/inicio")
	public String registrar(Usuario  usuario) {
		return vistainicio;
	}
	
	@PostMapping(value = "/inicio")
	public String registrarUsuario(@Valid Usuario usuario, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		
		if(bindingResult.hasFieldErrors("correoElectronico")|bindingResult.hasFieldErrors("password")) {
			return vistainicio;
		}
		
		return vistainicio;
	}
	
	
	
	/**
	 * Contiene algunos atributos necesarios para las vistas.
	 * 
	 * @param model contiene los atributos que viajaran del controlador a las vistas.
	 */
	@ModelAttribute
	public void atributes(Model model) {
		model.addAttribute("roles",rolServices.getRoles());
		
	}
	
	
	/**
	 *  Es la ruta del archivo en el que se encuentra la pagina de  inicio.
	 * 
	 */
	private static final String vistainicio="inicio-registro/inicio";

	@Autowired
	private RolServices rolServices;
	
}
