package mx.com.gm.web;

import lombok.extern.slf4j.Slf4j;
import mx.com.gm.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller//controolador de tipo MVC, realiza una configuracion muy similar
@Slf4j// para poder generar log ya que utilzamos loombok
public class ControladorInicio {
    
    @Autowired//inyectar dependencia, cualquier objeto de otra clase
    private PersonaService personaService;//esto permite usar los metodos de la interface crud repository
    
    /*spring busca el tipo que es la interface pero encuenta 
    la instancia de la implementacion que se ha marcado 
    como @service,spring busca la implementacion de esa 
    interface e inyecta la implementacion de esa clase,
    como usaos la interface pdemos modificar la implmentacion 
    y no abra error de esa forma se desacoplan las capas y 
    desacoplamos la capa de datos de la capa de servicio al 
    inyectar la interface de personaDao, pero al extender de 
    crudrepository no fue necesario crear una implementacion 
    de la interface personaDao como en personaService
    */
    
   
    
    @GetMapping("/")//servlets necesita mas configuraciones, pero spring simplifica el trabajo con servlets
    public String inicio(Model model){//por la inyeccion de depensendias en spring se pueden enviar diferentes aprametros sin cambiar las anotacioen
        var personas = personaService.listarPersonas();
        log.info("Ejecutando el controlador Spring MVC");//teneos acceso a la variable log por loombok
        model.addAttribute("personas", personas);
        return "index";
    }
    
}
