package com.formacionbdi.springboot.app.item.models.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.formacionbdi.springboot.app.item.models.Item;
import com.formacionbdi.springboot.app.item.models.Producto;

@Service("serviceRestTemplate")//es del estereotipo component, se registra como un bean, service significa buissness service que e suna fachada para acceder a los datos, se esta trabajando con datos con logica de negocio
public class ItemServiceImpl implements ItemService {

	@Autowired
	private RestTemplate clienteRest;//se registro el bean para poderlo inyectar y utilizar
	
	
	@Override
	public List<Item> findAll() {
		List<Producto> productos = Arrays.asList(clienteRest.getForObject("http://localhost:8001/listar", Producto[].class));
		return productos.stream().map(p -> new Item(p,1)).collect(Collectors.toList());//esto convierte cada objeto del array de productos en un objeto item con una cantidad de default como 1
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		Map<String, String> pathVariables = new HashMap<String, String>();
		pathVariables.put("id", id.toString());
		Producto producto = clienteRest.getForObject("http://localhost:8001/ver/{id}", Producto.class, pathVariables); 
		return new Item(producto, cantidad);
	}

}
