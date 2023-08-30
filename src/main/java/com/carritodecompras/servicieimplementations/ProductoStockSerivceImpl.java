package com.carritodecompras.servicieimplementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.carritodecompras.model.Categoria;
import com.carritodecompras.model.ProductoStock;
import com.carritodecompras.model.Usuario;
import com.carritodecompras.repositories.ProductoStockRepository;
import com.carritodecompras.repositories.UsuarioRepository;
import com.carritodecompras.servicies.ProductoStockServices;

@Service
public class ProductoStockSerivceImpl implements ProductoStockServices {

	@Override
	public ProductoStock getById(Long id) {
		
		return productoStockRepository
				.findById(id)
				.orElse(null);
	}

	@Override
	public List<ProductoStock> getProductos() {
		
		return productoStockRepository.findAll();
	}

	@Override
	public void guardarProducto(ProductoStock productoStock) {
	
		productoStockRepository.save(productoStock);
	}

	@Override
	public void eliminarProducto(ProductoStock productoStock) {
	
		productoStockRepository.delete(productoStock);
	}

	@Override
	public void actualizarProducto(ProductoStock productoStock) {
	
		productoStockRepository.save(productoStock);
	}

	@Override
	public List<ProductoStock> deMenorAMayorPrecio() {
		
		return productoStockRepository.findAll(Sort.by(Direction.ASC,"precio"));
	}

	@Override
	public List<ProductoStock> deMayorAMenorPrecio() {
		
		return productoStockRepository.findAll(Sort.by(Direction.DESC,"precio"));
	}

	@Override
	public List<ProductoStock> porCategoria(Categoria categoria) {
		
		return productoStockRepository.findByCategoria(categoria);
	}

	@Override
	public List<ProductoStock> porRangoDePrecios(Double min, Double Max) {
		
		return productoStockRepository.findByPrecioBetween(min, Max);
	}
	
	
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Override
	public List<ProductoStock> getProductosByVendedor(Long id) {
		
		Usuario vendedor= usuarioRepository
				.findById(id)
				.orElse(null);
		
		return productoStockRepository.findByVendedor(vendedor);
	}
	
	
	@Autowired
	private ProductoStockRepository productoStockRepository;


}
