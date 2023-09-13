package com.carritodecompras.servicieimplementations;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.carritodecompras.model.Categoria;
import com.carritodecompras.model.ProductoStock;
import com.carritodecompras.model.Usuario;
import com.carritodecompras.repositories.ProductoStockRepository;
import com.carritodecompras.servicies.CategoriaServices;
import com.carritodecompras.servicies.ProductoStockServices;
import com.carritodecompras.servicies.VendedorServices;

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
	public void guardarProducto(ProductoStock productoStock, Authentication authentication) {
		
		Usuario Vendedor=vendedorServices.GetbyEmail(authentication.getName());
		productoStock.setFechaDePublicacion(Date.valueOf(LocalDate.now()));
		productoStock.setVendedor(Vendedor);
		productoStockRepository.save(productoStock);
	}

	@Override
	public void eliminarProducto(Long id) {
	
		productoStockRepository.deleteById(id);
	}

	
	
	@Override
	public void actualizarProducto(ProductoStock productoStock) {
		
		ProductoStock productoStockActualizar=productoStockRepository
				.findById(productoStock.getId())
				.get();
		
		Categoria categoria= categoriaServices
				.getById(productoStock
						.getCategoria()
						.getId());
		
		
		productoStockActualizar.setNombre(productoStock.getNombre());
		productoStockActualizar.setUnidadesDisponibles(productoStock.getUnidadesDisponibles());
		productoStockActualizar.setPrecio(productoStock.getPrecio());
		productoStockActualizar.setDescripcion(productoStock.getDescripcion());
		
				
		productoStockActualizar.setCategoria(categoria);
		
		productoStockRepository.save(productoStockActualizar);
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
	public List<ProductoStock> porCategoria(Long id) {
		
		Categoria categoria= categoriaServices.getById(id);
		
		return productoStockRepository.findByCategoria(categoria);
	}
	@Override
	public List<ProductoStock> porRangoDePrecios(Double min, Double Max) {
		
		return productoStockRepository.findByPrecioBetween(min, Max);
	}
	
	
	@Override
	public Page<ProductoStock> getProductos(Pageable pageable) {
		
		return productoStockRepository.findAll(pageable);
	}

	

	@Override
	public List<ProductoStock> porFechaDepublicacion() {
		
		return productoStockRepository.findAll(Sort.by(Direction.DESC, "fechaDePublicacion"));
	}

	
	@Override
	public List<ProductoStock> porCantidadDisponible() {
		
		return productoStockRepository.findAll(Sort.by(Direction.DESC, "unidadesDisponibles"));
	}
	


	@Override
	public List<ProductoStock> porPrecioMenorA(Double precio) {
		
		return productoStockRepository.findAll()
				.stream()
				.filter(P -> P.getPrecio()<=precio)
				.collect(Collectors.toCollection(ArrayList::new));
	}

	
	@Override
	public List<ProductoStock> porPrecioMayorA(Double precio) {
		
		return productoStockRepository.findAll()
				.stream()
				.filter(P -> P.getPrecio()>=precio)
				.collect(Collectors.toCollection(ArrayList::new));
	}
	

	
	
	
	
	@Autowired
	private ProductoStockRepository productoStockRepository;

	@Autowired
	private VendedorServices vendedorServices;

	@Autowired
	private CategoriaServices categoriaServices;



}
