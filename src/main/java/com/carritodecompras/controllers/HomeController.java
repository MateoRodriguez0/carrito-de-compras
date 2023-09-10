package com.carritodecompras.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.carritodecompras.model.ProductoStock;
import com.carritodecompras.servicies.CategoriaServices;
import com.carritodecompras.servicies.ProductoStockServices;

/**
 * controlador de vista principal. 
 * 
 * 
 *@author Mateo j. Rodriguez Chico
 *
 *@since 1.0
 *
 */

@Controller
@RequestMapping(value = "/carritodecompras")
public class HomeController {

	
	/**
	 * devuelve la ubicacion del archivo en el que se encuentra la pagina principal.
	 * 
	 * @return la pagina principal.
	 */
	@GetMapping(value = "/")
	public String getHome() {
		
		return home;
	}
	
	
	/**
	 * redirige a la pagina principal de un usuario Cliente.
	 * 
	 * @param model contiene los atributos de las vistas.
	 * @return la pagina principal.
	 */
	@GetMapping(value ="/principal")
	public String principal(Model model,Pageable page) {
			
		Page<ProductoStock> productos =productoStockServices.getProductos(page);
		model.addAttribute("productos",productos);
		model.addAttribute("ispageable", true);
		
		return vistaprincipal;
	}
	
	
	
	/**
	 * busca un productoCarrito por id y devuelve una pagina cargada con la informacion del producto.
	 * 
	 * @param id identificador del productoCarrito que se va a ver la informacion.
	 * @param model contiene los atributos de las vistas.
	 * @return la pagina de detalles de un producto.
	 */
	@GetMapping( value = "/producto/{id}/informacion")
	public String informaciondelProductoCarrito(@PathVariable("id")Long id,Model model) {
		
		ProductoStock productoStock=productoStockServices.getById(id);
		model.addAttribute("productoInfo",productoStock);
		model.addAttribute("delCarrito", true);
		
		return vistaInformacionProducto;
	}
	
	
	
	/**
	 * Contiene algunos atributos necesarios para las vistas.
	 * 
	 * @param model contiene los atributos de las vistas.
	 */
	@ModelAttribute
	public void atributes(Model model) {
		
		model.addAttribute("categorias", categoriaServices.getCategoriasAsc());
		
	}
	

	
	private final String home="principal/home";
	private final String vistaprincipal="principal/principal";
	private final String vistaInformacionProducto="principal/informacionproducto";
	
	@Autowired
	private ProductoStockServices productoStockServices;

	@Autowired
	private CategoriaServices categoriaServices;
}
