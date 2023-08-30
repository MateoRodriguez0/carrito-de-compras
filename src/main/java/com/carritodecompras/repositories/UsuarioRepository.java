package com.carritodecompras.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carritodecompras.model.Usuario;


/**
 *Repositorio para manejar persistencia de los vendedores en la base de datos.
 * 
 *@author Mateo j. Rodriguez Chico
 *
 *@since 1.0
 *
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	boolean existsByCorreoElectronico(String correoElectronico);
}
