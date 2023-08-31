package com.restaurante.microservicios.msccatalogo.service;

import com.restaurante.microservicios.common.response.ApiResponseBuilder;
import com.restaurante.microservicios.common.response.Response;
import com.restaurante.microservicios.msccatalogo.entity.EstadoRegistros;
import com.restaurante.microservicios.msccatalogo.repository.EstadoRegistroRepository;
import com.restaurante.microservicios.msccatalogo.utils.Constante;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EstadoRegistroService {


    private EstadoRegistroRepository estadosRegistrosRepository;
    private final ApiResponseBuilder<Object> responseBuilder;

    public EstadoRegistroService(EstadoRegistroRepository estadosRegistrosRepository, ApiResponseBuilder responseBuilder) {
        this.estadosRegistrosRepository = estadosRegistrosRepository;
        this.responseBuilder = responseBuilder;
    }
    @Transactional(readOnly = true)
    public Response<Object> listado(){
        List<EstadoRegistros> lista = estadosRegistrosRepository.findAll();
        if(lista.isEmpty()) return responseBuilder.respuestaSinResultado(null).getBody();
        return responseBuilder.respuestaConExito(lista).getBody();
    }

    @Transactional(readOnly = true)
    public Response<Object>  obtenerPorId(long codigo){
        Optional<EstadoRegistros> registro = estadosRegistrosRepository.findById(codigo);
        if(registro.isPresent()){
            return responseBuilder.respuestaConExito(registro.get()).getBody();
        }
        return responseBuilder.respuestaSinResultado(null).getBody();

    }

    public Response<Object> guardar(EstadoRegistros registro)  {
        registro.setEstadoRegistro(estadosRegistrosRepository.findMaxId()+1);
        registro.setCreacionFecha(new Date());
        EstadoRegistros nuevo = estadosRegistrosRepository.save(registro);
        if(nuevo!=null)
            return responseBuilder.respuestaConExito("0").getBody();
        else
            return responseBuilder.respuestaConError(Constante.ESTADO_ERROR).getBody();
    }
}
