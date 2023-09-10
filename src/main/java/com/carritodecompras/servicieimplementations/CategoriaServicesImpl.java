package com.carritodecompras.servicieimplementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.carritodecompras.model.Categoria;
import com.carritodecompras.repositories.CategoriaRepository;
import com.carritodecompras.servicies.CategoriaServices;


@Service
public class CategoriaServicesImpl implements CategoriaServices {

	@Override
	public List<Categoria> getCategoriasAsc() {
		return categoriaRepository.findAll(Sort.by(Direction.ASC,"nombre"));
	}
	
	@Override
	public Categoria getById(Long id) {
		
		return categoriaRepository
				.findById(id)
				.orElse(null);
	}	
	@Autowired
	private CategoriaRepository categoriaRepository;



}
