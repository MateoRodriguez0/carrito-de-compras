package com.carritodecompras.servicies;

import java.util.List;

import com.carritodecompras.model.Rol;

public interface RolServices {

	public Rol getById(Long id);
	public List<Rol> getRoles();
}
