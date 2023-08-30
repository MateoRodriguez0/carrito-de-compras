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
import com.carritodecompras.servicies.ClienteServices;
import com.carritodecompras.servicies.RolServices;
import com.carritodecompras.servicies.VendedorServices;

import jakarta.validation.Valid;

/**
 * controlador de pagina de registro de  de cuentas.
 * 
 *@author Mateo j. Rodriguez Chico
 *
 *@since 1.0
 *
 */

@Controller
@RequestMapping(value = "/carritodecompras")
public class RegistroController {

	/**
	 * 
	 * Devuelve la ubicacion del archivo en el que se encuentra la pagina de registro de cuentas.
	 * 
	 * @return la pagina de registro. 
	 */
	@GetMapping(value = "/registro")
	public String registrar(Usuario usuario) {
		return registro;
	}
	
	
	@PostMapping(value = "/registro")
	public String registrarCuenta(@Valid Usuario usuario,BindingResult bindingResult,RedirectAttributes redirectAttributes,Model model) {
		
		/**
		 * agregar mensaje al modelo en caso de que el correo electronico ya este en la base de datos
		 */
		if(clienteServices.existsByEmail(usuario.getCorreoElectronico())|
				vendedorServices.existsByEmail(usuario.getCorreoElectronico())) {
			model.addAttribute("msjEmailExistente", msjEmailExistente);
			
		}
		
		/**
		 * verificar si todos los campos estan rellenados correctamente  
		 * verificar si el correo electronico no se encuentra registrado para que no ocurra una exepcion
		 * 
		 */
		if(bindingResult.hasErrors()| !usuario.validPasword()|!usuario.esMayordeEdad()|
				clienteServices.existsByEmail(usuario.getCorreoElectronico())| 
				vendedorServices.existsByEmail(usuario.getCorreoElectronico())) {
			
			return registro;
		}
		
		
		else {
			if(usuario.getRol().getId()==1) {
				clienteServices.crearCuenta(usuario);
			}
			else if(usuario.getRol().getId()==2) {
				vendedorServices.crearCuenta(usuario);
			}
			redirectAttributes.addFlashAttribute("msjcuentacreada",creada );
			redirectAttributes.addFlashAttribute("usuario",usuario); 
			return vistainicio;
		}
		
		
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
	 *  Es la ruta del archivo en el que se encuentra la pagina de registro.
	 * 
	 */
	private final String registro="inicio-registro/registro";
	
	/**
	 * mensaje que se mostrará al redireccionar la pagina despues de crear una cuenta. 
	 * 
	 */
	private final String creada="¡ Tu cuenta se creó con exito !";
	
	
	
	/**
	 *  Es la ruta del archivo en el que se encuentra la pagina de  inicio.
	 * 
	 */
	private  final String vistainicio="redirect:/carritodecompras/inicio";
	
	private  final String msjEmailExistente="El correo electronico ya está registrado";
	@Autowired
	private RolServices rolServices;

	@Autowired
	private ClienteServices clienteServices;
	
	@Autowired
	private VendedorServices vendedorServices;
}
