package com.carritodecompras.servicies;

import java.util.List;

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
	
	
	public List<ProductoCarrito> getProductos();
	
	public void guardarProducto(ProductoCarrito productoCarrito);
	
	public void eliminarProducto(ProductoCarrito productoCarrito);
	
	public void actualizarProducto(ProductoCarrito productoCarrito);
}
