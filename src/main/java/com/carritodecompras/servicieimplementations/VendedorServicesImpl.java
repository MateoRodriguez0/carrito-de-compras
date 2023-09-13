package com.carritodecompras.servicieimplementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carritodecompras.model.Usuario;
import com.carritodecompras.repositories.UsuarioRepository;
import com.carritodecompras.servicies.VendedorServices;

@Service
public class VendedorServicesImpl implements VendedorServices {

	@Override
	public void crearCuenta(Usuario vendedor) {
		
		usuarioRepository.save(vendedor);
	}

	
	
	@Override
	public Boolean existsByEmail(String email) {
		
		return usuarioRepository.existsByCorreoElectronico(email);
	}

	@Override
	public Usuario GetbyEmail(String email) {
		
		return usuarioRepository.findByCorreoElectronico(email);
	}
	
	@Autowired
	private UsuarioRepository usuarioRepository;


}
