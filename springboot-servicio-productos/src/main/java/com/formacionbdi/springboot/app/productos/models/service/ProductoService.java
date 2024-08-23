package com.formacionbdi.springboot.app.productos.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacionbdi.springboot.app.productos.models.entity.Producto;
import com.formacionbdi.springboot.app.productos.models.repository.ProductoDao;

@Service//se marca la clase dentro de spring como un bean un componente, service es un estereotipo de component de esa forma despues podemos inyectarlo en otras clases
public class ProductoService implements IProductoService{

	@Autowired
	private ProductoDao productoDao;//inyectamos el productodao 
	
	@Override
	@Transactional(readOnly = true)//importar de spring framework, para que se sincornice con la base de datos
	public List<Producto> findAll() {
		return (List<Producto>)productoDao.findAll();//iterable es una superinterface de list 
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findById(Long id) {
		return productoDao.findById(id).orElse(null);//optional nos permite sabes y manejar si el objeto esta presente y se pueden validar con varios metodos
	}

}
