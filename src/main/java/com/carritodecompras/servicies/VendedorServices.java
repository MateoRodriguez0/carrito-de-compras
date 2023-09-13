package com.carritodecompras.servicies;


import com.carritodecompras.model.Usuario;

public interface VendedorServices {

	/**
	 * 
	 * @param vendedor usuario que se va a guardar en la base de datos.
	 */
	void crearCuenta (Usuario vendedor);
	
	/**
	 * 
	 * @param email es el username de los usuarios en la aplicacion.
	 * @return true si encuentra el usuario.
	 */
	Boolean existsByEmail(String email);
	
	/**
	 * 
	 * @param email es el username de los usuarios en la aplicacion.
	 * @return el usuario correspondiente al email.
	 */
	Usuario GetbyEmail(String email);
	
}
