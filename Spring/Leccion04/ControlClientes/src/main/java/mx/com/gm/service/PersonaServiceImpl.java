package mx.com.gm.service;

import java.util.List;
import mx.com.gm.dao.PersonaDao;
import mx.com.gm.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service//asi spring la reconoce como una clase de servicio, ya puede ser usada por el controlador de spring, ahora se puede inyectar en el controlador
public class PersonaServiceImpl implements PersonaService{

    @Autowired//el controlador ya no utilizara la capa de datos si no la capa de servicios
    private PersonaDao personaDao;//se conecta la capa de servicio con la de datos por medio de esta instancia
    
    @Override
    @Transactional(readOnly=true)//por que este metodo solo es un select y solo lee info de la bd
    public List<Persona> listarPersonas() {
        return (List<Persona>) personaDao.findAll();//findAll regresa un tipo object y no una lista
    }

    @Override
    @Transactional//con la anotacion sin otro parametro se especifica la transaccion del rollback y el commit, con la etiqueta se inicia otra transaccion si no hay una activa
    public void guardar(Persona persona) {
        personaDao.save(persona);
    }

    @Override
    @Transactional
    public void eliminar(Persona persona) {
        personaDao.delete(persona);
    }

    @Override
    @Transactional(readOnly=true)
    public Persona encontrarPersona(Persona persona) {
        return personaDao.findById(persona.getIdPersona()).orElse(null);//se agrega el orElse por que el metodo findbyid regresa un tipo optional y con eso podemos decidir que hacemos si nos devuelve un null
        //este metodo no fallara, en caso de no encontrar el id regresara un null
    }
    
    /*Al trabajar con la capa DAO  se maneja el 
    concepto de transacciones, esto quiere 
    decir que cualquier operacione sobre la 
    base de datos se pueda realizar un rollback 
    al fallar o un commit al ser exitosa, 
    POR ESO EN LA CAPA de servicio se cuida los
    metodos que usen la base de datos por eso se usa
    la anotacion @transactional y se especifica la 
    accion que realiza el metodo 
    */
}
