package com.carritodecompras.vendedor.services;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.carritodecompras.model.Producto;

@Service
public class ProductosVendedorServiceImpl implements ProductosVendedorService {
	
	
	public ProductosVendedorServiceImpl() {
		productos=new LinkedList<>();
		agregarProducto(new Producto(01,"bolso toto","bolso para las fechas de colegio","utiles escolares",50000.0,24));
		agregarProducto(new Producto(02,"carrito de control remoto","carrito de bateria a control remoto","jugueteria",130000.0,1000));
		agregarProducto(new Producto(03,"barbie","barbie exclusiva modelo 1970","juegueteria",35000.0,20));
		agregarProducto(new Producto(04,"audifonos inalambricos","audifonos de bluetooh duracion de la carga 10 horas","tecnologia",230000.0,100));
	}
		@Override
	public Producto getById(Integer id) {
		
		return productos.stream()
				.filter(p ->p.getId().equals(id))
				.findFirst()
				.orElse(null);
	}

	@Override
	public List<Producto> getProductos() {
		return productos;
	}

	@Override
	public boolean eliminarProducto(Producto producto) {
		if(productos.contains(producto)) {
			return productos.remove(producto);
		}
		else {
			return false;
		}
		
	}

	@Override
	public void actualizarProducto(Producto producto) {
	}

	@Override
	public void agregarProducto(Producto producto) {
		productos.add(producto);
		
	}
	
	private List<Producto> productos;

}
