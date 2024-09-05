package com.formacionbdi.springboot.app.item.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.formacionbdi.springboot.app.item.models.Producto;

@FeignClient(name= "servicio-productos", url="localhost:8001")
public interface ProductoClienteRest {
	
	@GetMapping("/listar")//en el controlador se usa para mapear las rutas, los handler a enpoints y en feign cliente se especifica la ruta para obtener consumir el servicio y obtener el json pero convertido  a nuestros objetos
	public List<Producto> listar();
	
	@GetMapping("/ver/{id}")//el endpoint se conectara al endpoint del servicio producto 
	public Producto detalle(@PathVariable Long id);

}
