package com.unicauca.demo.services;
import com.unicauca.demo.entities.Persona;
import com.unicauca.demo.repositories.PersonaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService implements BaseService<Persona>{
    @Autowired
    private PersonaRepository personaRepositery;

    @Override
    @Transactional
    public List<Persona> findAll() throws Exception {
        try{
            return personaRepositery.findAll();
        }catch(Exception exc){
            throw new Exception(exc.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona findById(Long pId) throws Exception {
        try{
            Optional<Persona> varPersona = personaRepositery.findById(pId);
            return varPersona.get();
        }catch(Exception exc){
            throw new Exception(exc.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona Save(Persona pEntity) throws Exception {
        try{
            return personaRepositery.save(pEntity);
        }catch(Exception exc){
            throw new Exception(exc.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona update(Long pId, Persona pEntity) throws Exception {
        try {
            Optional<Persona> entityOptional = personaRepositery.findById(pId);
            Persona persona = entityOptional.get();
            persona.setNombre(pEntity.getNombre());
            persona.setApellido(pEntity.getApellido());
            persona.setDni(pEntity.getDni());
            return personaRepositery.save(entityOptional.get());
        }catch(Exception exc){
            throw new Exception(exc.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long pId) throws Exception {
        try {
            if (personaRepositery.existsById(pId)) {
                personaRepositery.deleteById(pId);
                return true;
            }else{
                throw new Exception();
            }
        } catch (Exception exc) {
            throw new Exception(exc.getMessage());
        }
    }
}
