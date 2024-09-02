package com.formacionbdi.springboot.app.item.models;

public class Item {

	private Producto producto;//
	private Integer cantidad;//puede recibir nullos por eso se usa el wrapprer

	public Item() {//siempre e sbueno tener un constructor por defecto cuando tenemos uno especifico con parametros
	}

	public Item(Producto producto, Integer cantidad) {
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	public Double getTotal() {
		return producto.getPrecio() * cantidad.doubleValue();//convertimos catidad de entero a double
	}

}
