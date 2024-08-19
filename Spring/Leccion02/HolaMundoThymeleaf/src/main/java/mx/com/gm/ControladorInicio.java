package mx.com.gm;

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
    
    @Value("${index.saludo}")//la estiqueta de org.spring para lllamar a las clave valor usanndoo la sintaxis de expression lenguage
    private String saludo;
    
    
    
    @GetMapping("/")//servlets necesita mas configuraciones, pero spring simplifica el trabajo con servlets
    public String inicio(Model model){//por la inyeccion de depensendias en spring se pueden enviar diferentes aprametros sin cambiar las anotacioens
        var mensaje = "Mensaje con Thymeleaf";
        
        var persona = new Persona();
        persona.setNombre("Juan");
        persona.setApellido("Perez");
        persona.setEmail("jpoerez@mail.com");
        persona.setTelefono("554443322");
        
        var persona2 = new Persona();
        persona2.setNombre("Karla");
        persona2.setApellido("Gomez");
        persona2.setEmail("kGomez@mail.com");
        persona2.setTelefono("13229900");
        
       // var personas = new ArrayList(); //esta version ya tiene inferencia de tipos
        //personas.add(persona);
        //personas.add(persona);
        
        
        //otra forma de crear el arreglo
        //var personas = Arrays.asList(persona, persona2);
        
        var personas = new ArrayList();
        
        log.info("Ejecutando el controlador Spring MVC");//teneos acceso a la variable log por loombok
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("saludo", saludo);
        //model.addAttribute("persona", persona);
        model.addAttribute("personas", personas);
        
        return "index";
    }
    
}
