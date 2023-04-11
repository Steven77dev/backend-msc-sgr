package com.restaurante.microservicios.msccatalogo.service;

import com.restaurante.microservicios.msccatalogo.entity.EstadoRegistros;
import com.restaurante.microservicios.msccatalogo.utils.ApiResponse;
import com.restaurante.microservicios.msccatalogo.utils.ResponseBuilder;
import com.restaurante.microservicios.msccatalogo.repository.EstadoRegistroRepository;
import com.restaurante.microservicios.msccatalogo.utils.Constante;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EstadoRegistroService {


    private EstadoRegistroRepository estadosRegistrosRepository;
    private final ResponseBuilder responseBuilder;

    public EstadoRegistroService(EstadoRegistroRepository estadosRegistrosRepository, ResponseBuilder responseBuilder) {
        this.estadosRegistrosRepository = estadosRegistrosRepository;
        this.responseBuilder = responseBuilder;
    }
    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> listado(){
        List<EstadoRegistros> lista = estadosRegistrosRepository.findAll();
        if(lista.isEmpty()) return responseBuilder.respuestaSinResultado(null);
        return responseBuilder.respuestaConExito(lista);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse>  obtenerPorId(long codigo){
        Optional<EstadoRegistros> registro = estadosRegistrosRepository.findById(codigo);
        if(registro.isPresent()){
            return responseBuilder.respuestaConExito(registro.get());
        }
        return responseBuilder.respuestaSinResultado(null);

    }

    public ResponseEntity<ApiResponse> guardar(EstadoRegistros registro)  {
        registro.setEstadoRegistro(estadosRegistrosRepository.findMaxId()+1);
        registro.setCreacionFecha(new Date());
        EstadoRegistros nuevo = estadosRegistrosRepository.save(registro);
        if(nuevo!=null)
            return responseBuilder.respuestaConExito("0");
        else
            return responseBuilder.respuestaConError(Constante.ESTADO_ERROR);
    }
}
