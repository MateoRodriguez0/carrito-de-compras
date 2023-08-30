package com.carritodecompras.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carritodecompras.model.ProductoCarrito;
import com.carritodecompras.model.Usuario;

import java.util.List;


/**
 *Repositorio para manejar persistencia de productos en carrito en la base de datos.
 * 
 *@author Mateo j. Rodriguez Chico
 *
 *@since 1.0
 *
 */
public interface ProductoCarritoRepository extends JpaRepository<ProductoCarrito, Long>{
	
	
	List<ProductoCarrito> findByCliente(Usuario cliente);

}
