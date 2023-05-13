package com.interconectados.sgrvbackend.utils;

import com.restaurante.microservicios.common.response.Response;

public class ConvertirApiResponse {

    public static ApiResponse exito(Response response){
        return ApiResponse.exito(response.getMensaje(),response.getRespuesta());
    }
}
