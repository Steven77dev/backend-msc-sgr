package com.restaurante.microservicios.mscpersona.service.impl;

import com.restaurante.microservicios.mscpersona.entity.Persona;
import com.restaurante.microservicios.mscpersona.repository.PersonaRepository;
import com.restaurante.microservicios.mscpersona.utils.ApiResponse;
import com.restaurante.microservicios.mscpersona.utils.Constante;
import com.restaurante.microservicios.mscpersona.utils.ResponseBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

   private  PersonaRepository personaRepository;
    private final ResponseBuilder responseBuilder;

    public PersonaService(PersonaRepository personaRepository, ResponseBuilder responseBuilder) {
        this.personaRepository = personaRepository;
        this.responseBuilder = responseBuilder;
    }
    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> listado(){
       List<Persona> personas = personaRepository.findAll();
       if(personas.isEmpty()) return  responseBuilder.respuestaSinResultado(null);
       return responseBuilder.respuestaConExito(personas);
   }

   @Transactional(readOnly = true)
   public ResponseEntity<ApiResponse> obtenerUsuarioPorId(String codigo){
      Optional<Persona> persona = personaRepository.findById(codigo);
        if(persona.isPresent()){
            return responseBuilder.respuestaConExito(persona.get());
        }
        return responseBuilder.respuestaSinResultado(null);
   }

   public ResponseEntity<ApiResponse> guardar(Persona persona){
       Persona nuevo = personaRepository.save(persona);
       if(nuevo!=null)
           return responseBuilder.respuestaConExito("0");
       else
           return responseBuilder.respuestaConError(Constante.ESTADO_ERROR);
   }
}
