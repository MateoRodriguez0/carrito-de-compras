package com.carritodecompras.servicies;

import java.util.List;

import org.springframework.security.core.Authentication;

import com.carritodecompras.model.ProductoCarrito;

/**
 *Esta interface proporciona metodos necesarios para implementar en la clase de servicio de los productos en carrito.
 *
 * 
 *@author Mateo j. Rodriguez Chico
 *
 *@since 1.0
 *
 */
public interface ProductoCarritoServices {

	
	/**
	 * busca un ProductoCarrito por id.
	 * 
	 * @param id identificador del ProductoCarrito.
	 * @return el ProductoCarrito encontrado.
	 */
	public ProductoCarrito getById(Long id);
	
	/**
	 * buasca todos los registro de la entidad ProductoCarrito en la base de datos.
	 * 
	 * @return toda la lista resultante de la consulta.
	 */
	public List<ProductoCarrito> getProductos();
	
	/**
	 * 
	 * @param productoCarrito producto que sera guardado en la base de datos.
	 * @param authentication  contiene los datos del usuario que se encuentra actualmente en la session, para asignar el productoCarrito a ese usuario.
	 */
	public void guardarProducto(ProductoCarrito productoCarrito,Authentication authentication);
	
	/**
	 * 
	 * @param productoCarrito producto que sera eliminado.
	 */
	public void eliminarProducto(ProductoCarrito productoCarrito);
	
	/**
	 * 
	 * @param productoCarrito producto que sera actualizado.
	 */
	public void actualizarProducto(ProductoCarrito productoCarrito);
}
