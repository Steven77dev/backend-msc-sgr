package com.interconectados.sgrvbackend.service;

import com.interconectados.sgrvbackend.Objeto;
import com.interconectados.sgrvbackend.models.request.BusqMesasRequest;
import com.interconectados.sgrvbackend.models.request.BusqPedidosMesaRequest;
import com.interconectados.sgrvbackend.models.request.BusqProductoPorPedirRequest;
import com.interconectados.sgrvbackend.utils.ApiResponse;
import com.interconectados.sgrvbackend.utils.ConvertirApiResponse;
import com.restaurante.microservicios.common.response.Response;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl {

    private final ProductoService productoService;

    public ProductoServiceImpl(ProductoService productoService) {
        this.productoService = productoService;
    }

    public ApiResponse listarProductosPedir(BusqProductoPorPedirRequest request) {

        if(Objeto.anyEmpty(request.getAlmacen(), request.getEntidad())){
            return ApiResponse.parametrosIncorrectos();
        }

        Response responseEntity=  productoService.listarProductosPedir(request).getBody();
        if (responseEntity.hayError()) {
            return ApiResponse.error();
        } else {
            return ConvertirApiResponse.exito(responseEntity);
        }
    }

}
