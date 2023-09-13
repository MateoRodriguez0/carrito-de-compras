package com.carritodecompras.servicies;

import java.util.List;

import com.carritodecompras.model.Rol;

public interface RolServices {

	

	/**
	 * 
	 * @param id id del usuario
	 * @return el rol del usuario
	 */
	public Rol getById(Long id);
	
	/**
	 * 
	 * @return la lista de roles en la base de datos.
	 */
	public List<Rol> getRoles();
}
