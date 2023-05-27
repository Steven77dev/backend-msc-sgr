package com.restaurante.microservicios.mscfinanzas.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restaurante.microservicios.common.response.ApiResponseBuilder;
import com.restaurante.microservicios.common.response.Response;
import com.restaurante.microservicios.common.utils.Serializer;
import com.restaurante.microservicios.mscfinanzas.models.request.BusqIngresoEgresoRequest;
import com.restaurante.microservicios.mscfinanzas.models.request.BusqIngresoPersonalRequest;
import com.restaurante.microservicios.mscfinanzas.models.response.CajaCierreAnteriorResponse;
import com.restaurante.microservicios.mscfinanzas.models.response.ResumenEgrePersonalResponse;
import com.restaurante.microservicios.mscfinanzas.repository.EgresoDiarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class EgresoDiarioService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final ApiResponseBuilder<Object> responseBuilder;
    private EgresoDiarioRepository egresoDiarioRepository;
    private static ObjectMapper objectMapper = Serializer.objectMapper();


    public EgresoDiarioService(EgresoDiarioRepository egresoDiarioRepository, ApiResponseBuilder<Object> responseBuilder){
        this.responseBuilder = responseBuilder;
        this.egresoDiarioRepository = egresoDiarioRepository;
    }

    @Transactional(readOnly = true)
    public Response<Object> listadoEgresosPersonal(BusqIngresoPersonalRequest request){
        logger.info("Obteniendo resumen de egresos del personal {}", request );
        List<Map<String, Object>> respuesta = egresoDiarioRepository.resumenEgresoPersonal(2,"","",request.getLocal(),request.getDesFecha(), request.getCodPersonal(), request.getDesFecHoraInicio(), request.getDesFecHoraFin());
        List<ResumenEgrePersonalResponse> egresoResponseList = objectMapper.convertValue(respuesta,new TypeReference<List<ResumenEgrePersonalResponse>>() {});
        return egresoResponseList.isEmpty() ? responseBuilder.respuestaSinResultado(null).getBody() : responseBuilder.respuestaConExito(egresoResponseList).getBody();

    }

    @Transactional(readOnly = true)
    public Response<Object> cierreCajaDiaAnterior(BusqIngresoEgresoRequest request){
        logger.info("Obteniendo monto de cierre del día anterior {}", request );
        Map<String, Object> respuesta = egresoDiarioRepository.cierreCajaDiaAnterior(4,"","",request.getLocal(),request.getDesFecha(), "", "", "");
        CajaCierreAnteriorResponse cajaCierreAnteriorResponse = objectMapper.convertValue(respuesta,CajaCierreAnteriorResponse.class);
        return cajaCierreAnteriorResponse.getTotal()==null ? responseBuilder.respuestaSinResultado(null).getBody() : responseBuilder.respuestaConExito(cajaCierreAnteriorResponse).getBody();

    }
}
