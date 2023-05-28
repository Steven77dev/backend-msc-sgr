package com.interconectados.sgrvbackend.service.finanzas;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.interconectados.sgrvbackend.Objeto;
import com.interconectados.sgrvbackend.models.request.BusqAperturaCierreRequest;
import com.interconectados.sgrvbackend.service.Redis;
import com.interconectados.sgrvbackend.utils.ApiResponse;
import com.interconectados.sgrvbackend.utils.ConvertirApiResponse;
import com.restaurante.microservicios.common.response.Response;
import com.restaurante.microservicios.common.utils.Serializer;
import org.springframework.stereotype.Service;

@Service
public class IngresoDiarioService {

    private final IngresoDiarioRest ingresoDiarioRest;
    private static ObjectMapper objectMapper = Serializer.objectMapper();
    private final Redis redis;

    public IngresoDiarioService(IngresoDiarioRest ingresoDiarioRest, Redis redis) {
        this.ingresoDiarioRest = ingresoDiarioRest;
        this.redis = redis;
    }

    public ApiResponse verificarAperturaCaja(BusqAperturaCierreRequest request) {
        request.setLocal(redis.obtenerDato("codLocal").toString());
        if(Objeto.anyEmpty(request.getLocal()).booleanValue()){
            return ApiResponse.parametrosIncorrectos();
        }

        Response<?> responseEntity=  ingresoDiarioRest.verificarAperturaCaja(request);
        if (responseEntity.hayError()) return ApiResponse.error();
        else {
            return ConvertirApiResponse.exito(responseEntity);
        }
    }
}
