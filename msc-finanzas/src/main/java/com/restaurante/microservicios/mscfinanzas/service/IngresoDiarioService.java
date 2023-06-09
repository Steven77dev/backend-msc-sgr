package com.restaurante.microservicios.mscfinanzas.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restaurante.microservicios.common.response.ApiResponseBuilder;
import com.restaurante.microservicios.common.response.Response;
import com.restaurante.microservicios.common.utils.Serializer;
import com.restaurante.microservicios.mscfinanzas.models.request.*;
import com.restaurante.microservicios.mscfinanzas.models.response.*;
import com.restaurante.microservicios.mscfinanzas.repository.IngresoDiarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class IngresoDiarioService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final ApiResponseBuilder<Object> responseBuilder;
    private IngresoDiarioRepository ingresoDiarioRepository;
    private static ObjectMapper objectMapper = Serializer.objectMapper();


    public IngresoDiarioService(IngresoDiarioRepository ingresoDiarioRepository, ApiResponseBuilder<Object> responseBuilder){
        this.responseBuilder = responseBuilder;
        this.ingresoDiarioRepository = ingresoDiarioRepository;
    }

    @Transactional(readOnly = true)
    public Response<Object> listadoIngresosVsEgresos(BusqIngresoEgresoRequest request){
        logger.info("Obteniendo ingresos vs egresos de {}", request );
        List<Map<String, Object>> respuesta = ingresoDiarioRepository.ingresosVsEgresos(4,"","",request.getLocal(),request.getDesFecha(),"","","");
        List<IngresoEgresoResponse> ingresoEgresoResponseList = objectMapper.convertValue(respuesta,new TypeReference<List<IngresoEgresoResponse>>() {});
        return ingresoEgresoResponseList.isEmpty() ? responseBuilder.respuestaSinResultado(null).getBody() : responseBuilder.respuestaConExito(ingresoEgresoResponseList).getBody();

    }

    @Transactional(readOnly = true)
    public Response<Object> datosAperturaCierre(BusqAperturaCierreRequest request){
        logger.info("Obteniendo apertura y cierre de caja {}", request );
        Map<String, Object> respuesta = ingresoDiarioRepository.datosAperturaCierre(6,"","",request.getLocal(),request.getDesFecha(),request.getCodPersonal(),"","");
        AperturaCierreResponse aperturaCierreResponse = objectMapper.convertValue(respuesta,AperturaCierreResponse.class);
        return aperturaCierreResponse==null ? responseBuilder.respuestaSinResultado(null).getBody() : responseBuilder.respuestaConExito(aperturaCierreResponse).getBody();

    }

    @Transactional(readOnly = true)
    public Response<Object> verificarAperturaCaja(BusqAperturaCierreRequest request){
        logger.info("Verificar apertura de caja {}", request );
        Map<String, Object> respuesta = ingresoDiarioRepository.datosAperturaCierre(3,"","",request.getLocal(),request.getDesFecha(),"","","");
        AperturaCajaResponse aperturaCajaResponse = objectMapper.convertValue(respuesta,AperturaCajaResponse.class);
        System.out.println(aperturaCajaResponse);
        return aperturaCajaResponse==null ? responseBuilder.respuestaSinResultado(null).getBody() : responseBuilder.respuestaConExito(aperturaCajaResponse).getBody();

    }

    @Transactional(readOnly = true)
    public Response<Object> listadoIngresosPersonal(BusqIngresoPersonalRequest request){
        logger.info("Obteniendo resumen de ingresos del persona {}", request );
        List<Map<String, Object>> respuesta = ingresoDiarioRepository.resumenIngresoPersonal(2,"","",request.getLocal(),request.getDesFecha(), request.getCodPersonal(), request.getDesFecHoraInicio(), request.getDesFecHoraFin());
        List<ResumenIngrePersonalResponse> ingresoResponseList = objectMapper.convertValue(respuesta,new TypeReference<List<ResumenIngrePersonalResponse>>() {});
        return ingresoResponseList.isEmpty() ? responseBuilder.respuestaSinResultado(null).getBody() : responseBuilder.respuestaConExito(ingresoResponseList).getBody();

    }


    @Transactional
    public Response<Object> cuadrarCaja(CuadrarCajaRequest request){
        logger.info("Cuadrar caja {}", request );
        String nroRspta =ingresoDiarioRepository.cuadrarCaja(2,request.getLocal(),request.getFecEmision(),request.getEntidad(),request.getEmisor(),request.getFechaApertura(),request.getFechaCierre(),request.getIdCaja(),request.getSession());
        SqlSPResponse codigoSPResponse = new SqlSPResponse();
        codigoSPResponse.setCodigoRspta(nroRspta);
        return !nroRspta.equals("501") ? responseBuilder.respuestaConError(codigoSPResponse).getBody() : responseBuilder.respuestaConExito(codigoSPResponse).getBody();

    }

    @Transactional
    public Response<Object> cerrarCaja(CerrarCajaRequest request){
        logger.info("Cerrar caja {}", request );
        String nroRspta =ingresoDiarioRepository.cerrarCaja(2,request.getLocal(),request.getFecEmision(),request.getEntidad(),request.getEmisor(),request.getFechaApertura(),request.getFechaCierre(), request.getObservacion(), request.getIdCaja(),request.getSession());
        SqlSPResponse codigoSPResponse = new SqlSPResponse();
        codigoSPResponse.setCodigoRspta(nroRspta);
        return !nroRspta.equals("501") ? responseBuilder.respuestaConError(codigoSPResponse).getBody() : responseBuilder.respuestaConExito(codigoSPResponse).getBody();

    }
}
