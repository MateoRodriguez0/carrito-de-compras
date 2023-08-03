package com.carritodecompras.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.carritodecompras.model.Producto;
import com.carritodecompras.vendedor.services.ProductosVendedorService;

import jakarta.validation.Valid;

@Controller
@RequestMapping(value = "/carritodecompras/vendedor")
public class VendedorController {
	
	@GetMapping(value ="/misproductos")
	public String listarProductos(Model model ) {
		model.addAttribute("productos", productosVendedorService.getProductos());
		return listar;
	}
	
	@GetMapping(value ="/producto/actualizar/{id}")
	public String vistaactualizarProducto(@PathVariable(name = "id",required = true)Integer id,Model model) {
		Producto producto=productosVendedorService.getById(id);
		model.addAttribute("productoActualizar", producto);
		return vistaactualizar;
	}
	
	@GetMapping(value ="/eliminar")
	public String eliminarProducto() {
		
		return eliminar;
	}
	
	@GetMapping(value ="/producto/nuevo")
	public String vistaagregarProducto(Producto producto) {
		
		return vistaagregar;
	}
	@GetMapping(value ="/")
	public String principal(Producto producto) {
		
		return vistaprincipal;
	}
	
	
	@PostMapping(value ="/producto/agregar")
	public String agregarProducto(@Valid Producto producto,BindingResult bindingResult,RedirectAttributes redirectAttributes) {
		if(bindingResult.hasErrors()) {
			return vistaagregar;
		}
		else {
			productosVendedorService.agregarProducto(producto);
			redirectAttributes.addFlashAttribute("msj",msjAgregado);
			return listado;
		}
		
	}
	@PostMapping(value ="/producto/actualizado")
	public String actualizarProducto(@Valid Producto producto,BindingResult bindingResult,RedirectAttributes redirectAttributes) {
		if(bindingResult.hasErrors()) {
			return vistaactualizar;
		}
		else {
			redirectAttributes.addFlashAttribute("msj",msjActualizado);
			return listado;
		}
		
	}
	
	private static final String listar="vistasvendedores/listado";
	private static final String vistaactualizar="vistasvendedores/actualizarproducto";
	private static final String vistaagregar="vistasvendedores/agregarproducto";
	private static final String vistaprincipal="vistasvendedores/principal";
	private static final String eliminar="redirect:/vistasvendedores/misproductos/";
	private static final String listado="redirect:/carritodecompras/vendedor/misproductos";
	private static final String msjAgregado="Se ha agregado un Nuevo producto al listado";
	private static final String msjActualizado="Se ha actualizado un producto del listado ";
	
	@Autowired
	private ProductosVendedorService productosVendedorService;
}
