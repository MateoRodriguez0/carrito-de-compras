package com.carritodecompras.servicieimplementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.carritodecompras.model.Rol;
import com.carritodecompras.repositories.RolRepository;
import com.carritodecompras.servicies.RolServices;

@Service
public class RolServicesImpl implements RolServices {

	@Override
	public Rol getById(Long id) {
		
		return rolRepository
				.findById(id)
				.orElse(null);
	}

	@Override
	public List<Rol> getRoles() {
		
		return rolRepository.findAll(Sort.by(Direction.ASC, "nombre"));
	}

	
	@Autowired
	private RolRepository rolRepository;
}
