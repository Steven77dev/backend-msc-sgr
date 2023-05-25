package com.restaurante.microservicios.msccomercial.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restaurante.microservicios.common.response.ApiResponseBuilder;
import com.restaurante.microservicios.common.response.Response;
import com.restaurante.microservicios.common.utils.Serializer;
import com.restaurante.microservicios.msccomercial.models.request.BusqMesasRequest;
import com.restaurante.microservicios.msccomercial.models.request.BusqPedidosMesaRequest;
import com.restaurante.microservicios.msccomercial.models.response.ListadoMesasAtencionResponse;
import com.restaurante.microservicios.msccomercial.models.response.PedidosMesaResponse;
import com.restaurante.microservicios.msccomercial.repository.PedidoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class PedidoService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final ApiResponseBuilder<Object> responseBuilder;
    private PedidoRepository pedidoRepository;
    private static ObjectMapper objectMapper = Serializer.objectMapper();

    public PedidoService(PedidoRepository pedidoRepository, ApiResponseBuilder<Object> responseBuilder){
        this.pedidoRepository = pedidoRepository;
        this.responseBuilder = responseBuilder;
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Response<Object>> listadoMesasLocal(BusqMesasRequest request){
        logger.info("Listado de mesas disponibles u ocupadas del local {}", request );
        List<Map<String, Object>> respuesta = pedidoRepository.listadoMesas(1, request.getEntidad(),request.getLocal(),request.getFecha(), request.getEstado());
        List<ListadoMesasAtencionResponse> listadoMesasAtencionResponse = objectMapper.convertValue(respuesta,new TypeReference<List<ListadoMesasAtencionResponse>>() {});
        return listadoMesasAtencionResponse.isEmpty() ? responseBuilder.respuestaSinResultado(null) : responseBuilder.respuestaConExito(listadoMesasAtencionResponse);

    }

    @Transactional(readOnly = true)
    public ResponseEntity<Response<Object>> listarPedidosPorMesa(BusqPedidosMesaRequest request){
        logger.info("Listado de mesas disponibles u ocupadas del local {}", request );
        List<Map<String, Object>> respuesta = pedidoRepository.listarPedidosPorMesa(1, request.getSeriePedido(), request.getNroPedido(), request.getItemPedido(), request.getEntidad(), request.getAlmacen(),"","","");
        List<PedidosMesaResponse> pedidosMesaResponses = objectMapper.convertValue(respuesta,new TypeReference<List<PedidosMesaResponse>>() {});
        System.out.println(pedidosMesaResponses.get(0));
        return pedidosMesaResponses.isEmpty() ? responseBuilder.respuestaSinResultado(null) : responseBuilder.respuestaConExito(pedidosMesaResponses);

    }
}
