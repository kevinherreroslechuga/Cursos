package mx.com.gm.web;

import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Persona;
import mx.com.gm.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
    
    @GetMapping("/agregar")//spring busca un objeto tipo persona y si no lo encuentra va a crea run nuevo objeto y lo va a insertar
    public String agregar(Persona persona){
        return "modificar";//va a realizar tanto los inserts como updates
    }
    
    @PostMapping("/guardar")
    public String guardar(Persona persona){//spring va a buscar el objeto que se lleno en el form y lo inyectara en el parametro, solo le pasara la instancia en memoria del objeto que se lleno
        personaService.guardar(persona);//el metodo save se comportara como un update si el valor de idpersona no esta vacio en el objeto a guardar 
        return "redirect:/";//el redirect redirecciona  al pagina de inicio al terminar el proceso
    }
    
    //cuando es un link la solicitud debe ser un get
    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model){//el parametro de persona lo va a inicializar directamente con el objeto person, inicialisa el objeto con el valor de tipo persona
        persona = personaService.encontrarPersona(persona);//al recibir el idPersona en el mapeo de lo que nos llega en la plantilla thymeleaf el metodo save al ver que ya ahi un idPersona el metodo se comportara como un update en lugar de un insert
        model.addAttribute("persona", persona);
        return "modificar";
    }
    
    @GetMapping("/eliminar")// este es un query parameter donde no necesita el idPersona en el path, se lo pasamos con el query parameter.  @GetMapping("/eliminar/{idPersona") este es un path parameter
    public String eliminar(Persona persona){
        personaService.eliminar(persona);
        return "redirect:/";
    }
}
