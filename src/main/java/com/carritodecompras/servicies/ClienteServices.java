package com.carritodecompras.servicies;

import java.util.List;

import com.carritodecompras.model.ProductoCarrito;

import com.carritodecompras.model.Usuario;


public interface ClienteServices {

	
	public void crearCuenta (Usuario cliente);
	
	
	/**
	 * busca un cliente por email.
	 * 
	 * @param email correo electronico de un cliente
	 * @return true si existe o false si no existe.
	 */
	public Boolean existsByEmail(String email);
	
	/**
	 * busca un cliente por id y devuelve un  lista de ProductoCarrito asosciado a este mismo.
	 * 
	 * @param id identificador del cliente.
	 * @return lista de ProductoCarrito asosciado al idCliente.
	 */
	public List<ProductoCarrito> getProductosByCliente(Long id);
}
