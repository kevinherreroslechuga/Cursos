package com.formacionbdi.springboot.app.productos.models.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="productos")
public class Producto implements Serializable{
	
	//Serializable es una buena practica que permite convertir el objeto en bites y se usa mucho cuando queremos guardar el objeto entity en una sesion http,como al trabajar en carros de compra o si queremos convertir o serializar nuestro objeto para guardarlo en un archivo de texto
	
	//identificador para la serializacion
	/**
	 * 
	 */
	private static final long serialVersionUID = 1285454306356845809L;

	
	@Id//anotacion para detonar la primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY )//se indica la estrategia de generacion de la llave
	private Long id;
	
	private String nombre;
	private Double precio;
	
	@Column(name="create_at")//este es el nombre en la base 
	@Temporal(TemporalType.DATE)//para especificar la fomra en que se guardara la fecha en la base de datos
	private Date createAt;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

}
