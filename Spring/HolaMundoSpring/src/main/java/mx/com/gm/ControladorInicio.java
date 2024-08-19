package mx.com.gm;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//primer paso para que spring reconoca la clase, deciende de controller que deciende de component que es lo que permite a sprin reconocer la clase como una clase de spring.
@Slf4j// para poder generar log ya que utilzamos loombok
public class ControladorInicio {
    
    @GetMapping("/")
    public String inicio(){
        log.info("Ejecutando el controlador REST");//teneos acceso a la variable log por loombok
        log.debug("mas detalle del controlador");
        return "Hola Mundo con Spirng";
    }
    
}
