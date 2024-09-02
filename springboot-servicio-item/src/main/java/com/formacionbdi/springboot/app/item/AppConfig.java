package com.formacionbdi.springboot.app.item;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {//nos permite crear objetos, componentes de spring y los podemos registrar en el contenedor pormedio de metodoso y la anotacion de bean
	
	@Bean("clienteRest")//con esta anotacion se guarda el objeto en el contenedor con el identificador del mismo nombre que el metodo a menos que lo configuremos como aqui
	public RestTemplate registrarRestTemplate() {
		return new RestTemplate();//el objeto q	ue se retorna se guardara en el contenedor por que lo anotamos con bean,
		// este obejto funciona como un cliente http, para trabajar ocn api rest y poder acceder a recursos que estan en otros microservicios
	}
}
