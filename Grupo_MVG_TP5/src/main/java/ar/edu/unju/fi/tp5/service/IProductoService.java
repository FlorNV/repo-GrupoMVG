package ar.edu.unju.fi.tp5.service;

import java.util.List;

import ar.edu.unju.fi.tp5.model.Producto;

public interface IProductoService {
	
	public void generarTablaProductos();
	public void agregarProducto(Producto producto);
	public List<Producto> getProductos();
	public Producto colsultarUltimo();

}
