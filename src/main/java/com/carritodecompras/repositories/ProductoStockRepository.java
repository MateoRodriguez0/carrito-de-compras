package com.carritodecompras.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carritodecompras.model.Categoria;
import com.carritodecompras.model.ProductoStock;
import com.carritodecompras.model.Usuario;

import java.util.List;


/**
 *Repositorio para manejar persistencia de productos en stock en la base de datos.
 * 
 *@author Mateo j. Rodriguez Chico
 *
 *@since 1.0
 *
 */
public interface ProductoStockRepository extends JpaRepository<ProductoStock, Long>{

	List<ProductoStock> findByCategoria(Categoria categoria);
	
	List<ProductoStock> findByPrecioBetween(Double min,Double max);
	
	
	List<ProductoStock> findByVendedor(Usuario vendedor);
}
