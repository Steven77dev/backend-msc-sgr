package com.restaurante.microservicios.msccatalogo.service;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restaurante.microservicios.common.response.ApiResponseBuilder;
import com.restaurante.microservicios.common.response.Response;
import com.restaurante.microservicios.common.utils.Serializer;
import com.restaurante.microservicios.msccatalogo.entity.Tarjeta;
import com.restaurante.microservicios.msccatalogo.models.response.TarjetaEntidadResponse;
import com.restaurante.microservicios.msccatalogo.repository.TarjetaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class TarjetaService {

    private final TarjetaRepository repository;
    private final ApiResponseBuilder<Object> responseBuilder;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    public TarjetaService(TarjetaRepository repository, ApiResponseBuilder responseBuilder){
        this.repository = repository;
        this.responseBuilder = responseBuilder;
    }

    @Transactional(readOnly = true)
    public Response<Object> listado(int entidad, int estado){
        logger.info("listado de tarjeta por entidad {} y estado {}", entidad, estado );
        List<Map<String, Object>> lista = repository.findTarjetasByEntidadAndEstadoRegistro(entidad, estado);
        if(lista.isEmpty()) return responseBuilder.respuestaSinResultado(null).getBody();
        return responseBuilder.respuestaConExito(lista).getBody();
    }

}
