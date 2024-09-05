package com.formacionbdi.springboot.app.item.models.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.formacionbdi.springboot.app.item.clientes.ProductoClienteRest;
import com.formacionbdi.springboot.app.item.models.Item;

@Service("serviceFeign")//por defecto el nombre de clase es el nombre en minusculas pero tambien se puede especificar uno de esta foirma
//@Primary//Se especifica que esta configuracion debe ser la principal en el servicio, de esta forma el componente itemserviceFeign sera el que se inyecte por deault en la clase controllador al hacer autowired a la interface  itemservice
public class ItemServiceFeign implements ItemService {

	@Autowired
	private ProductoClienteRest clienteFeign; //al estar anotada con feigncliente pasa a ser utilizado por spring y los metodos que tiene especificados la interfas productoClienteRest se implementaran en tiempo de ejecutcion
	
	@Override
	public List<Item> findAll() {
		return clienteFeign.listar().stream().map(p -> new Item(p,1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		return new Item (clienteFeign.detalle(id), cantidad);
	}

}
