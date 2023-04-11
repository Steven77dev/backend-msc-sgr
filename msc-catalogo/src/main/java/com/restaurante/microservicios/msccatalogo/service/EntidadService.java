package com.restaurante.microservicios.msccatalogo.service;

import com.restaurante.microservicios.msccatalogo.entity.Entidad;
import com.restaurante.microservicios.msccatalogo.utils.ApiResponse;
import com.restaurante.microservicios.msccatalogo.utils.ResponseBuilder;
import com.restaurante.microservicios.msccatalogo.repository.EntidadRepository;
import com.restaurante.microservicios.msccatalogo.utils.Constante;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EntidadService {


    private EntidadRepository entidadRepository;
    private final ResponseBuilder responseBuilder;

    public EntidadService(EntidadRepository entidadRepository, ResponseBuilder responseBuilder) {
        this.entidadRepository = entidadRepository;
        this.responseBuilder = responseBuilder;
    }
    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> listado(){
        List<Entidad> lista = entidadRepository.findAll();
        if(lista.isEmpty()) return responseBuilder.respuestaSinResultado(null);
        return responseBuilder.respuestaConExito(lista);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse>  obtenerPorId(long codigo){
        Optional<Entidad> registro = entidadRepository.findById(codigo);
        if(registro.isPresent()){
            return responseBuilder.respuestaConExito(registro.get());
        }
        return responseBuilder.respuestaSinResultado(null);

    }

    public ResponseEntity<ApiResponse> guardar(Entidad registro)  {
        registro.setEntidad(entidadRepository.findMaxId()+1);
        registro.setCreacionFecha(new Date());
        Entidad nuevo = entidadRepository.save(registro);
        if(nuevo!=null)
            return responseBuilder.respuestaConExito("0");
        else
            return responseBuilder.respuestaConError(Constante.ESTADO_ERROR);
    }
}
