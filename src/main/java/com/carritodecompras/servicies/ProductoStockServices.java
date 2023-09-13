package com.carritodecompras.servicies;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;

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

	public Page<ProductoStock> getProductos(Pageable pageable);
	
	public void guardarProducto(ProductoStock productoStock, Authentication authentication);
	
	public void eliminarProducto(Long id);
	
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
	public List<ProductoStock> porCategoria(Long id);
	
	
	/**
	 * devuelve una lista de ProductoStock por rango de precio.
	 * @param min valor minimo del precio.
	 * @param Max valor maximo del precio.
	 * @return lista de ProductoStock entre el rango de precios.
	 */
	public List<ProductoStock> porRangoDePrecios(Double min, Double Max);
	
	/**
	 * busca productos en orden por fecha de pucblicacion.
	 * 
	 * @return la lista de resultados de la busqueda.
	 */
	public List<ProductoStock> porFechaDepublicacion();

	/**
	 * busca productos en orden por cantidad dipsonimble de mayor a menor.
	 * 
	 * @return la lista de resultados de la busqueda.
	 */
	public List<ProductoStock> porCantidadDisponible();
	
	
	/**
	 *  busca productos que tengan un precio menor al argumento.
	 * 
	 * @return la lista de resultados de la busqueda.
	 */
	public List<ProductoStock> porPrecioMenorA(Double precio);
	
	/**
	 * busca productos que tengan un precio mayor al argumento.
	 * 
	 * @return la lista de resultados de la busqueda.
	 */
	public List<ProductoStock> porPrecioMayorA(Double precio);

	
}
