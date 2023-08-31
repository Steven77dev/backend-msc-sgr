package com.restaurante.microservicios.msccatalogo.service;

import com.restaurante.microservicios.common.response.ApiResponseBuilder;
import com.restaurante.microservicios.common.response.Response;
import com.restaurante.microservicios.msccatalogo.entity.Entidad;
import com.restaurante.microservicios.msccatalogo.repository.EntidadRepository;
import com.restaurante.microservicios.msccatalogo.utils.Constante;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EntidadService {

    private EntidadRepository entidadRepository;
    private final ApiResponseBuilder<Object> responseBuilder;

    public EntidadService(EntidadRepository entidadRepository, ApiResponseBuilder responseBuilder) {
        this.entidadRepository = entidadRepository;
        this.responseBuilder = responseBuilder;
    }
    @Transactional(readOnly = true)
    public Response<Object> listado(){
        List<Entidad> lista = entidadRepository.findAll();
        if(lista.isEmpty()) return responseBuilder.respuestaSinResultado(null).getBody();
        return responseBuilder.respuestaConExito(lista).getBody();
    }

    @Transactional(readOnly = true)
    public Response<Object>  obtenerPorId(long codigo){
        Optional<Entidad> registro = entidadRepository.findById(codigo);
        if(registro.isPresent()){
            return responseBuilder.respuestaConExito(registro.get()).getBody();
        }
        return responseBuilder.respuestaSinResultado(null).getBody();

    }

    public Response<Object> guardar(Entidad registro)  {
        registro.setEntidad(entidadRepository.findMaxId()+1);
        registro.setCreacionFecha(new Date());
        Entidad nuevo = entidadRepository.save(registro);
        if(nuevo!=null)
            return responseBuilder.respuestaConExito("0").getBody();
        else
            return responseBuilder.respuestaConError(Constante.ESTADO_ERROR).getBody();
    }
}
