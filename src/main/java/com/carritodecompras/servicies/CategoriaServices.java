package com.carritodecompras.servicies;

import java.util.List;

import com.carritodecompras.model.Categoria;

public interface CategoriaServices {

	/**
	 * devuelve lista de categorias ordenados en orden alfabetico por nombre.
	 * @return lista de categorias.
	 */
	public List<Categoria> getCategoriasAsc();
}
