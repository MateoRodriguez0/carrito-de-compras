package com.carritodecompras.servicies;

import java.util.List;

import com.carritodecompras.model.Categoria;
import com.carritodecompras.model.ProductoStock;

/**
 *Esta interface proporciona metodos necesarios para implementar en la clase de servicio de los productos en stock.
 * 
 *@author Mateo j. Rodriguez Chico
 *
 *@since 1.0
 *
 */
public interface ProductoStockServices {

	/**
	 * busca un ProductoStock por id.
	 * 
	 * @param id identificador del productoStock.
	 * @return producto encontrado por id.
	 */
	public ProductoStock getById(Long id);
	
	/**
	 * devuelve una lista que contiene todos los productos en stock de una base de datos.
	 * @return lista de ProductoStock.
	 */
	public List<ProductoStock> getProductos();
	
	public List<ProductoStock> getProductosByVendedor(Long id);
	
	public void guardarProducto(ProductoStock productoStock);
	
	public void eliminarProducto(ProductoStock productoStock);
	
	public void actualizarProducto(ProductoStock productoStock);

	/**
	 * devuelve una lista de ProductoStock ordenada por precio de menor a mayor.
	 * 
	 * @return lista de ProductoStock ordenada.
	 */
	public List<ProductoStock> deMenorAMayorPrecio();
	
	/**
	 * devuelve una lista de ProductoStock ordenada por precio de mayor a menor.
	 * 
	 * @return lista de ProductoStock ordenada.
	 */
	public List<ProductoStock> deMayorAMenorPrecio();
	
	
	/**
	 * devuelve una lista de ProductoStock por categoria.
	 * 
	 * @param categoria sera el predicado para realizar el filtrado.
	 * @return
	 */
	public List<ProductoStock> porCategoria(Categoria categoria);
	
	
	/**
	 * devuelve una lista de ProductoStock por rango de precio.
	 * @param min valor minimo del precio.
	 * @param Max valor maximo del precio.
	 * @return lista de ProductoStock entre el rango de precios.
	 */
	public List<ProductoStock> porRangoDePrecios(Double min, Double Max);
	
	
	
}
