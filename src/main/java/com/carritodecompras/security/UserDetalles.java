package com.carritodecompras.security;

import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.carritodecompras.model.Usuario;
import lombok.AllArgsConstructor;

/**
 * Esta clase maneja los detalles de los usuarios para manejar la seguridad de la aplicacion
 * 
 *@author Mateo j. Rodriguez Chico
 *
 *@since 1.1
 *
 */
@AllArgsConstructor
public class UserDetalles implements UserDetails{

	
	private static final long serialVersionUID = 1L;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return List.of(usuario.getRol());
	}

	@Override
	public String getPassword() {

		return usuario.getPassword();
	}

	@Override
	public String getUsername() {
		
		return usuario.getCorreoElectronico();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

	
	private final Usuario usuario;
}
