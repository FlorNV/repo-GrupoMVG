package ar.edu.unju.fi.tp5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp5.model.Compra;
import ar.edu.unju.fi.tp5.model.Producto;
import ar.edu.unju.fi.tp5.service.ICompraService;
import ar.edu.unju.fi.tp5.service.IProductoService;

@Controller
public class CompraController {

	
	@Autowired
	private Compra compra;
	@Autowired
	@Qualifier("compraUtilService")
	private ICompraService compraService;
	@Autowired
	@Qualifier("productoUtilService")
	private IProductoService productoService;
	
	@GetMapping("/compra/nueva")
	public String getCompraNuevaPage(Model model) {
		List<Producto> listaProductos = productoService.getProductos();
		model.addAttribute("compra", compra);
		model.addAttribute("productos", listaProductos);
		return "compranueva";
	}
	
	@PostMapping("/compra/guardar")
	public String getGuardarCompraPage(@ModelAttribute("compra")Compra compra) {
		compraService.guardarCompra(compra);
		return "resultadocompra";
	}
	
	@GetMapping("/compra/listado")
	public ModelAndView getListadoCompraPage() {
		ModelAndView model = new ModelAndView("compras");
		if(compraService.getCompras() == null)
			compraService.generarTablaCompras();
		model.addObject("compras", compraService.getCompras());
		return model;
	}
	
	@GetMapping("/compra/ultima")
	public String getCompraUltimoPage(Model model) {
		model.addAttribute(compraService.consultarUltimaCompra());
		return "ultimacompra";
	}
}
