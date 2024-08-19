package mx.com.gm.dao;

import mx.com.gm.domain.Persona;
import org.springframework.data.repository.CrudRepository;

public interface PersonaDao extends CrudRepository<Persona, Long>{//esta clase de crud repository agrega todo para hacer las funciones crud en las clases dao, es un tipo generico por eso especificamos la clase que manejara y el tipo de la llave primaria
    
    
}
