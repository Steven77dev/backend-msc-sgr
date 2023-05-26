package com.restaurante.microservicios.msccomercial.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restaurante.microservicios.common.response.ApiResponseBuilder;
import com.restaurante.microservicios.common.response.Response;
import com.restaurante.microservicios.common.utils.Serializer;
import com.restaurante.microservicios.msccomercial.models.request.BusqProductoPorPedirRequest;
import com.restaurante.microservicios.msccomercial.models.response.ProductosPorPedirResponse;
import com.restaurante.microservicios.msccomercial.repository.ProductoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ProductoService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final ApiResponseBuilder<Object> responseBuilder;
    private ProductoRepository productoRepository;
    private static ObjectMapper objectMapper = Serializer.objectMapper();

    public ProductoService(ProductoRepository productoRepository, ApiResponseBuilder<Object> responseBuilder){
        this.productoRepository = productoRepository;
        this.responseBuilder = responseBuilder;
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Response<Object>> productosPorPedir(BusqProductoPorPedirRequest request){
        logger.info("Listado de productos que tengo para pedir {}", request );
        List<Map<String, Object>> respuesta = productoRepository.buscarProductosPorAlmacenFamilia(11, request.getEntidad(),request.getAlmacen(),request.getFamilia(), request.getLocal(),"","");
        List<ProductosPorPedirResponse> productosAlmaFamResponse = objectMapper.convertValue(respuesta,new TypeReference<List<ProductosPorPedirResponse>>() {});
        return productosAlmaFamResponse.isEmpty() ? responseBuilder.respuestaSinResultado(null) : responseBuilder.respuestaConExito(productosAlmaFamResponse);

    }


}
