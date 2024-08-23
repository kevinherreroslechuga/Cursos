package com.formacionbdi.springboot.app.productos.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.formacionbdi.springboot.app.productos.models.entity.Producto;

public interface ProductoDao extends CrudRepository<Producto, Long>{//interface son un protocolo de metodos, de comportamiento para cumplir un  contrato
	//no es necesario colocar una anotacion para que spring reconosca esta interface por que extiende de crudrepository que ya es una clase que administra spring
	//buena practica es usar una clase service para implementar la interface dao en caso que se tengan muchos dao, se descoplan por medio de la clase service 
}
