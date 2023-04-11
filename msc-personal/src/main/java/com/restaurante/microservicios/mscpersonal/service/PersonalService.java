package com.restaurante.microservicios.mscpersonal.service;

import com.restaurante.microservicios.mscpersonal.entity.Personal;
import com.restaurante.microservicios.mscpersonal.utils.ApiResponse;
import com.restaurante.microservicios.mscpersonal.utils.ApiResponseBuilder;
import com.restaurante.microservicios.mscpersonal.repository.PersonalRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalService {

   private PersonalRepository personalRepository;
    private final ApiResponseBuilder responseBuilder;

    public PersonalService(PersonalRepository personalRepository, ApiResponseBuilder responseBuilder) {
        this.personalRepository = personalRepository;
        this.responseBuilder = responseBuilder;
    }
    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> listado(){
       List<Personal> personal = personalRepository.findAll();
       if(personal.isEmpty()) return  responseBuilder.respuestaSinResultado(null);
       return responseBuilder.respuestaConExito(personal);
   }

   @Transactional(readOnly = true)
   public ResponseEntity<ApiResponse> obtenerPorId(String codigo){
      Optional<Personal> personal = personalRepository.findById(codigo);
        if(personal.isPresent()){
            return responseBuilder.respuestaConExito(personal.get());
        }
        return responseBuilder.respuestaSinResultado(null);
   }


}
