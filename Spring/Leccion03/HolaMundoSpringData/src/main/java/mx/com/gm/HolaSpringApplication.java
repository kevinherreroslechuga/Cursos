package mx.com.gm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//spring contenedor de clases java, se conocen como beans y estos viven dentro del contenedor de spring
public class HolaSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HolaSpringApplication.class, args);
	}

        //@compnentScan la anotacion busca las clases dentro del paquete prncipal y subpaquetes
}
