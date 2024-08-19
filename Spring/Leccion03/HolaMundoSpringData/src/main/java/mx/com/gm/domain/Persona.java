package mx.com.gm.domain;

import lombok.Data;

@Data//esta anotacion es parte de loombok no de spring, es opcional utilizarla, es para crear todos los metodos de getters y setter para configurar la clase como un java bean
public class Persona {
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
}
