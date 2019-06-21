package com.mx.gapsy.examen.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.gapsy.examen.entity.Producto;
import com.mx.gapsy.examen.repository.ProductoRepository;
import com.mx.gapsy.examen.service.ProductoService;

@Service("productoServiceImpl")
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository productoRepository;
	
	public Producto saveUpdateProducto(Producto producto) {
		Producto productoR = productoRepository.save(producto);
		return productoR;
	}
	
	public void deleteProducto(Producto producto) {
		productoRepository.delete(producto);
	}
	
	public Iterable<Producto> getAllProductos() {
		Iterable<Producto> productoIter = productoRepository.findAll();
		return productoIter;
	}
	
	public Producto getProductoById(Producto producto) {
		Optional<Producto> productoR = productoRepository.findById(producto.getIdProducto());
		return productoR.get();
	}
	
}
