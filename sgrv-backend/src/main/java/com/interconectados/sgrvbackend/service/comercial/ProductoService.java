package com.interconectados.sgrvbackend.service.comercial;

import com.interconectados.sgrvbackend.Objeto;
import com.interconectados.sgrvbackend.models.request.BusqProductoPorPedirRequest;
import com.interconectados.sgrvbackend.service.Redis;
import com.interconectados.sgrvbackend.utils.ApiResponse;
import com.interconectados.sgrvbackend.utils.ConvertirApiResponse;
import com.restaurante.microservicios.common.response.Response;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

    private final ProductoRest productoService;
    private final Redis redis;
    public ProductoService(ProductoRest productoService, Redis redis) {
        this.productoService = productoService;
        this.redis = redis;
    }

    public ApiResponse listarProductosPedir(BusqProductoPorPedirRequest request) {
        request.setEntidad(Integer.parseInt(redis.codEntidad()));
        request.setAlmacen(redis.codAlmacen());
        request.setLocal(redis.codLocal());
        if(Objeto.anyEmpty(request.getAlmacen(), request.getEntidad(), request.getLocal()).booleanValue()){
            return ApiResponse.parametrosIncorrectos();
        }

        Response<?> responseEntity=  productoService.listarProductosPedir(request);
        System.out.println(responseEntity.getRespuesta());
        if (responseEntity.hayError()) {
            return ApiResponse.error();
        } else {
            return ConvertirApiResponse.exito(responseEntity);
        }
    }

}
