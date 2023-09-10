package com.carritodecompras.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * representa cada producto que se encuentra agregado en el carrito de compras de un Cliente.
 * 
 *@author Mateo j. Rodriguez Chico
 *
 *@since 1.0
 *
 */

@Entity
@Table(name = "productos en carrito")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoCarrito {

	
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Long id;
	
	@Column(name = "cantidad seleccionada")
	private Integer cantidadSeleccionada;
	
	@Column(name = "fecha de agregado")
	private Date fechaDeAgregado;
	
	
	/**
	 * identifica el producto de la tienda asociado a un producto agregado al carrito.
	 */
	@OneToOne()
	@JoinColumn(name = "IdProducto_Stock")
	private ProductoStock productoStock;
	
	/**
	 * identifica al cliente que ha agregado el producto en el carrito.
	 * un Cliente puede estar asociado a muchos objetos de tipo ProductoCarrito.
	 */
	@ManyToOne
	@JoinColumn(name = "idCliente")
	private Usuario cliente;
	
	
	
}
