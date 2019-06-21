package com.mx.gapsy.examen.rest;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.persistence.EntityNotFoundException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mx.gapsy.examen.entity.Producto;
import com.mx.gapsy.examen.service.ProductoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;

@Api("Rest productos")
@Component
@Path("/producto")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductoRestServlets {

	@Autowired
	private ProductoService productoService;
	
	@POST
	@Path("/saveUpdateProducto")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveUpdateProducto(@ApiParam
			@PathParam("idProducto") String idProducto,
			@PathParam("descripcion") String descripcion,
			@PathParam("modelo") String modelo,
			@PathParam("nombre") String nombre,
			@PathParam("precio") BigDecimal precio) {
		Producto producto = null;
		try {
			producto = productoService.saveUpdateProducto(setDataProducto(idProducto, descripcion, modelo, nombre, precio));
		} catch (EntityNotFoundException e) {
			
			return Response.status(404).build();
		}
		return Response.ok().entity(producto).build();
    }
	
	@DELETE
	@Path("/deleteProducto/{idProducto}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteProducto(@ApiParam @PathParam("idProducto") String idProducto) {
		try {
			productoService.deleteProducto(setDataProducto(idProducto, null, null, null, null));
		} catch (EntityNotFoundException e) {
			
			return Response.status(404).build();
		}
		return Response.ok().entity("La eliminación fue exitosa.").build();
    }
	
	@GET
	@Path("/getAllProductos")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllProductos() {
		Iterable<Producto> productos = new ArrayList<Producto>();
		try {
			productos = productoService.getAllProductos();
		} catch (EntityNotFoundException e) {
			
			return Response.status(404).build();
		}
		return Response.ok().entity(productos).build();
    }
	
	@GET
	@Path("/getProductoById/{idProducto}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProductoById(@ApiParam @PathParam("idProducto") String idProducto) {
		Producto producto = null;
		try {
			productoService.getProductoById(setDataProducto(idProducto, null, null, null, null));
		} catch (EntityNotFoundException e) {
			
			return Response.status(404).build();
		}
		return Response.ok().entity(producto).build();
    }
	
	private Producto setDataProducto(String idProducto, String descripcion, String modelo, String nombre,
			BigDecimal precio) {
		Producto producto = new Producto();
		producto.setIdProducto(idProducto);
		producto.setDescripcion(descripcion);
		producto.setModelo(modelo);
		producto.setNombre(nombre);
		producto.setPrecio(precio);
		return producto;
	}
}
