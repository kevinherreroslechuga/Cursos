package mx.com.gm.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Data//esta anotacion es parte de loombok no de spring, es opcional utilizarla, es para crear todos los metodos de getters y setter para configurar la clase como un java bean
@Entity//la clase se convierte en entidad de bd
@Table(name="persona")//a veces por el las mayusculas en el nombre de la clase con respecto al nombre en minusculas de la tabla a veces falla el mapeo, es mas problema en linux o mac
public class Persona implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id//SE INDICA CUAL CAMPO ES LA LLAVE PRIMARIA
    @GeneratedValue(strategy = GenerationType.IDENTITY)//SE INDICA COMO SE GENERARA ESTA LLAVE PRIMARIA
    private Long idPersona;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
}
