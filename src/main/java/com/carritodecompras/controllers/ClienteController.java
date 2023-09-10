package com.carritodecompras.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.carritodecompras.model.ProductoCarrito;
import com.carritodecompras.model.ProductoStock;
import com.carritodecompras.servicies.ClienteServices;
import com.carritodecompras.servicies.ProductoCarritoServices;
import com.carritodecompras.servicies.ProductoStockServices;


/**
 * controlador de las vistas y del funcionamiento de la aplicacion para los usuarios de tipo Cliente.
 * 
 *@author Mateo j. Rodriguez Chico
 *
 *@since 1.0
 * 
 */

@Controller
@RequestMapping(value = "/carritodecompras/cliente")
public class ClienteController {



	
	/**
	 * busca los el listado de ProductoCarrito asociado al Usuario con id y 
	 * devuelve la pagina carrito de compras con las lista de productos.
	 * 
	 * @param id identificador del producto en carrito
	 * @param model contiene los atributos de las vistas.
	 * @return la pagina carrito de compras con el listado de productos del cliente con id.
	 */
	@GetMapping( value = "/elcarrito/{id}")
	public String alCarrito(@PathVariable("id")Long id, Model model) {
		
		List<ProductoCarrito>productosCarrito=clienteServices.getProductosByCliente(id);
		model.addAttribute("ProductosCarrito", productosCarrito);
		
		return carrito;
	}
	
	/**
	 * busca un ProductoStock por id y lo agrega al modelo.
	 * 
	 * @param id identificador del productoStock que se va a ver la informacion.
	 * @param model contiene los atributos de las vistas.
	 * @return la pagina de detalles de un producto.
	 */
	@GetMapping( value = "/producto/{id}/informacion")
	public String informaciondelProducto(@PathVariable("id")Long id,Model model) {
		
		ProductoStock productoStock=productoStockServices.getById(id);
		model.addAttribute("productoInfo",productoStock);
		model.addAttribute("delCarrito", false);
		
		return vistaInformacionProducto;
	}
	
	

	
	
	/**
	 * busca un productoStock por id y devuelve una pagina para agregar el producto al carrito de compras de un Usuario.
	 * 
	 * @param id identificador del productoStock que se va a agregar al carrito de compras de un cliente.
	 * @param model contiene los atributos de las vistas.
	 * @return la vista para agregar el producto al carrito de compras.
	 */
	@GetMapping( value = "/producto/agregar/{id}")
	public String vistaAgregarAlCarrito(@PathVariable("id")Long id, Model model) {
		
		ProductoStock productoStock=productoStockServices.getById(id);
		model.addAttribute("productoAgregar",productoStock);
		
		return vistaAgregaralcarrito;
	}
	
	
	
	
	/**
	 * Busca un ProductoCarrito por id que sera actualizado y lo agrega al modelo.
	 * 
	 * @param id identificador del producto en carrito que se va a eliminar.
	 * @param model contiene los atributos de las vistas.
	 * @return la vista que contiene la informacion del producto que sera eliminado
	 */
	@GetMapping( value = "/elcarrito/{id}/eliminar")
	public String vistaElimnar(@PathVariable("id")Long id, Model model) {;
	
		ProductoCarrito productoCarrito=productoCarritoServices.getById(id);
		model.addAttribute("productoEliminar", productoCarrito);
		
	
		return vistaEliminar;
	}
	
	/**
	 * Elimina un ProductoCarrito de un cliente.
	 * 
	 * @param productoEliminar recibe el producto que contiene el id del producto que será eliminado
	 * @param redirectAttributes contiene atributos de redireccion de paginas.
	 * @return devuelve la pagina carrito de compras con las lista de producto.
	 */
	@GetMapping( value = "/elcarrito/eliminar")
	public String vistaAgregarAlCarrito(@ModelAttribute("productoEliminar") ProductoCarrito productoEliminar,RedirectAttributes redirectAttributes ) {
		System.out.println(productoEliminar.getId());
		
		productoCarritoServices.eliminarProducto(productoEliminar);
		
		return redirectAlCarrito;
	}
	
	
	
	/**
	 * Busca un ProductoCarrito por id que sera eliminado y lo agrega al modelo.
	 * 
	 * @param id identificador del producto en carrito que se va a actualizar.
	 * @param model contiene los atributos de las vistas.
	 * @return la vista que contiene la informacion del producto que sera actualizado
	 */
	@GetMapping( value = "/elcarrito/actualizar/{id}")
	public String vistaActualizar(@PathVariable("id")Long id, Model model) {;
	
		ProductoCarrito productoCarrito=productoCarritoServices.getById(id);
		
		model.addAttribute("productoActualizar", productoCarrito);
	
		return vistaActualizar;
	}
	
	/**
	 * Actualiza un ProductoCarrito teniendo en cuenta el id del producto y redirecciona al carrito de compras de un cliente.
	 * 
	 * @param productoActualizar recibe el producto que contiene los datos que se van a actualizar de un producto en la base de datos.
	 * @param redirectAttributes contiene atributos de redireccion de paginas.
	 * @return la pagina carrito de compras con el listado de productos.
	 */
	@PostMapping(value = "/producto/actualizar")
	public String ActualizarProducto(@ModelAttribute("productoActualizar") ProductoCarrito productoActualizar,RedirectAttributes redirectAttributes ) {
		
		
		ProductoCarrito productoCarrito=productoCarritoServices.getById(productoActualizar.getId());
		if(productoCarrito.getCantidadSeleccionada()!=productoActualizar.getCantidadSeleccionada()) {
			
			productoCarrito.setCantidadSeleccionada(productoActualizar.getCantidadSeleccionada());
			productoCarritoServices.actualizarProducto(productoCarrito);
			redirectAttributes.addFlashAttribute("msjActualizado",msjActualizado);
		}
		
		
		return redirectAlCarrito;
		
		
			
	}
	
	private final String vistaAgregaralcarrito="vistascompradores/agregaralcarrito";
	private final String vistaActualizar="vistascompradores/actualizar";
	private final String carrito="vistascompradores/carrito";
	private  final String redirectAlCarrito="redirect:/carritodecompras/cliente/elcarrito/10";
	private  final String msjActualizado="Se ha actualizado un producto del carrito de compras";
	private final String vistaEliminar="vistascompradores/eliminar";
	private final String vistaInformacionProducto="principal/informacionproducto";
	

	@Autowired
	private ProductoStockServices productoStockServices;
	
	@Autowired
	private ClienteServices clienteServices;

	@Autowired
	private ProductoCarritoServices productoCarritoServices;
	
	
}
