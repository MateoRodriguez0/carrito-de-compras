package com.carritodecompras.model;

import java.sql.Date;
import java.util.List;

import org.springframework.validation.annotation.Validated;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *Representa la entidad productos en stock en la base de datos.
 *Esta tabla esta relaciona relacionada con otras entidades.
 *Muchos productos en stock pueden tener el mismo Vendedor.
 *@author Mateo j. Rodriguez Chico
 *
 *@since 1.0
 *
 */


@Data
@Entity
@Table(name = "productos en stock")
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class ProductoStock {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre	")
	@NotEmpty(message = "Falta rellenar el campo nombre")
	private String nombre;
	
	@Column(name = "descripcion")
	@NotEmpty(message = "Falta rellenar el campo descripción")
	private String descripcion;
	
	
	@ManyToOne
	@JoinColumn(name = "IdCategoria")
	private Categoria categoria;
	
	@Column(name = "precio")
	@NotNull(message = "Falta rellenar el campo precio")
	@Min(value = 1,message = "Ese precio no es permitido" )
	private Double  precio;
	
	
	
	@Column(name = "cantidad disponible")
	@Min(value = 1,message = "la cantidad de unidades disponibles debe ser por lo menos 1 " )
	@NotNull(message = "Falta rellenar el campo unidades disponibles ")
	private Integer unidadesDisponibles;
	
	
	@Column(name = "fecha de publicacion")
	private Date fechaDePublicacion;
	
	/**
	 * Identifica el vendedor que ha publicado este producto en la tienda.
	 * Cada ProductoStock solo puede tener un Vendedor. 
	 */
	@ManyToOne
	@JoinColumn(name = "IdVendedor")
	private Usuario vendedor;
	
	
	/**
	 * lista de Productos que han sido agregado en el carrito de compras y hacen referencia a este producto de la tienda.
	 */
	@OneToMany(mappedBy = "productoStock",cascade = {CascadeType.REMOVE,CascadeType.PERSIST})
	private List<ProductoCarrito> posiblescompras;
}
