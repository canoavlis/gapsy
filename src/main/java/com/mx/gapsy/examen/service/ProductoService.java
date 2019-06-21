package com.mx.gapsy.examen.service;

import com.mx.gapsy.examen.entity.Producto;

public interface ProductoService {

	Producto saveUpdateProducto(Producto producto);
	
	void deleteProducto(Producto producto);
	
	Iterable<Producto> getAllProductos();
	
	Producto getProductoById(Producto producto);
}
