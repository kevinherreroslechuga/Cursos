package com.formacionbdi.springboot.app.productos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.springboot.app.productos.models.entity.Producto;
import com.formacionbdi.springboot.app.productos.models.service.IProductoService;

@RestController//esta anotacion convierte a json lo que retorna los metodos handler que esten mapeados a una ruta url ,seria controller si no se trabajara con api rest
public class ProductoController {
	
	@Autowired//inyectamos la clase service
	private IProductoService productoService;
	
	@GetMapping("/listar")
	public List<Producto>Listar(){//siempre publicos 
		return productoService.findAll();
	}
	
	@GetMapping("/ver/{id}")
	public Producto detalle(@PathVariable Long id) {
		return productoService.findById(id);
	}

}
