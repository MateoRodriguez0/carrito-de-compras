package com.carritodecompras.servicies;


import com.carritodecompras.model.Usuario;

public interface VendedorServices {

	
	public void crearCuenta (Usuario vendedor);
	
	
	public Boolean existsByEmail(String email);
	
}
