package com.carritodecompras.model;

import java.util.List;

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
 * Entidad para representar la tabla categorias en una base de datos.
 * una categoria puede tener muchos productos asociados.
 * 
 *@author Mateo j. Rodriguez Chico
 *
 *@since 1.o
 *
 */

@Data
@Entity
@Table(name = "categorias")
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	
	
	@Column(name = "descripcion")
	private String descripcion;
	
	/*
	 *Representa una lista de ProductoStocks que contiene todos los productos en stock que asociados a esta categoria.
	 */
	@OneToMany(mappedBy = "categoria", cascade = {CascadeType.REMOVE,CascadeType.PERSIST})
	private List<ProductoStock >productoStocks;
	
}
