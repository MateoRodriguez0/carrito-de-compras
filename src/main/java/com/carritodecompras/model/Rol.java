package com.carritodecompras.model;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidad que representa la tabla roles en una base de datos.
 * los roles permiten identificar el tipo de usuario en un contexto.
 * 
 *@author Mateo j. Rodriguez Chico
 *
 *@since 1.0
 *
 */

@Entity
@Table(name = "roles")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Rol implements GrantedAuthority{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	/**
	 *Representa una lista de Vendedor que contiene todos los usuarios en una base de datos cuyo rol sea de tipo Vendedor. 
	 */
	@OneToMany(mappedBy = "rol",cascade = {CascadeType.REMOVE})
	private List<Usuario> usuarios;

	@Override
	public String getAuthority() {
		
		return nombre;
	}
	
	
}
