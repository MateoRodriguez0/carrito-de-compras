package com.carritodecompras.model;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class Producto {

	private Integer id;
	
	@NotEmpty(message = "Falta rellenar el campo nombre")
	private String nombre;
	
	@NotEmpty(message = "Falta rellenar el campo descripción")
	private String descripcion;
	
	@NotEmpty(message = "Falta rellenar el campo categoria")
	private String categoria;
	
	@NotNull(message = "Falta rellenar el campo precio")
	@Min(value = 1,message = "Ese precio no es permitido" )
	private Double  precio;
	
	@Min(value = 1,message = "la cantidad de unidades disponibles debe ser por lo menos 1 " )
	@NotNull(message = "Falta rellenar el campo unidades disponibles ")
	private Integer unidadesDisponibles;
	
}
