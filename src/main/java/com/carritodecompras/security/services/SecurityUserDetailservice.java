package com.carritodecompras.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.carritodecompras.model.Usuario;
import com.carritodecompras.repositories.UsuarioRepository;
import com.carritodecompras.security.UserDetalles;

@Service
public class SecurityUserDetailservice implements UserDetailsService{

	
	
	


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario=usuarioRepository.findByCorreoElectronico(username);
		
		if(usuario!=null) {
			return new UserDetalles(usuario);
		}
	
		throw new UsernameNotFoundException("usuario no encontrado: "+usuario);
	}
	
	
	@Autowired 
	private UsuarioRepository usuarioRepository;
}
