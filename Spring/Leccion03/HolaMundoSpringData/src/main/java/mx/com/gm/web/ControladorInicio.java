package mx.com.gm.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Persona;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller//controolador de tipo MVC, realiza una configuracion muy similar
@Slf4j// para poder generar log ya que utilzamos loombok
public class ControladorInicio {
    
   
    
    @GetMapping("/")//servlets necesita mas configuraciones, pero spring simplifica el trabajo con servlets
    public String inicio(Model model){//por la inyeccion de depensendias en spring se pueden enviar diferentes aprametros sin cambiar las anotacioen
        log.info("Ejecutando el controlador Spring MVC");//teneos acceso a la variable log por loombok
        //model.addAttribute("personas", personas);
        return "index";
    }
    
}
