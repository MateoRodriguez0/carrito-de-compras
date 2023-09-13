package com.carritodecompras.servicies;

import java.util.List;

import org.springframework.security.core.Authentication;

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
	 * verifica si un ProductoStock ya esta asociado a un productoCarrito de un cliente.
	 * 
	 * @param id para identificar el productoStock.
	 * @param authentication contiene los datos del usuario que se encuentra actualmente en la session.
	 * @return true si encuentra el producto en el carrito de compras.
	 */
	boolean buscarProductoStockEnCarritoCliente(Long id,Authentication authentication);
	
	/**
	 * 
	 * @param email  es el username de los usuarios en la aplicacion.
	 * @return el usuario asociado al email.
	 */
	Usuario GetbyEmail(String email);
	
	/**
	 * busca un cliente por id y devuelve un  lista de ProductoCarrito asosciado a este mismo.
	 * 
	 * @param id identificador del cliente.
	 * @return lista de ProductoCarrito asosciado al idCliente.
	 */
	public List<ProductoCarrito> getProductosByCliente(Long id);
}
