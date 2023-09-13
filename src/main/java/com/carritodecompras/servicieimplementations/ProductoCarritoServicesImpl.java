package com.carritodecompras.servicieimplementations;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.carritodecompras.model.ProductoCarrito;
import com.carritodecompras.model.Usuario;
import com.carritodecompras.repositories.ProductoCarritoRepository;
import com.carritodecompras.servicies.ClienteServices;
import com.carritodecompras.servicies.ProductoCarritoServices;

@Service
public class ProductoCarritoServicesImpl implements ProductoCarritoServices{

	@Override
	public ProductoCarrito getById(Long id) {
		
		return productoCarritoRepository
				.findById(id)
				.orElse(null);
	}

	@Override
	public List<ProductoCarrito> getProductos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guardarProducto(ProductoCarrito productoCarrito, Authentication authentication) {
		
		Usuario cliente=clienteServices.GetbyEmail(authentication.getName());
		productoCarrito.setFechaDeAgregado(Date.valueOf(LocalDate.now()));
		productoCarrito.setCliente(cliente);
		productoCarritoRepository.save(productoCarrito);
	}

	@Override
	public void eliminarProducto(ProductoCarrito productoCarrito) {
		productoCarritoRepository.delete(productoCarrito);
	}

	@Override
	public void actualizarProducto(ProductoCarrito productoCarrito) {
	
		productoCarritoRepository.save(productoCarrito);
			
	
		
	}
	
	@Autowired
	private ProductoCarritoRepository productoCarritoRepository;

	@Autowired
	private ClienteServices clienteServices;

	
}
