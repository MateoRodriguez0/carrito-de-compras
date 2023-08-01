package com.carritodecompras.vendedor.services;

import java.util.List;

import com.carritodecompras.model.Producto;

public interface ProductosVendedorService {

	
	public Producto getById(Integer id);
	public List<Producto> getProductos();
	public boolean eliminarProducto(Producto producto);
	public void actualizarProducto(Producto producto);
	public void agregarProducto(Producto producto);
}
