package com.interconectados.sgrvbackend.utils;

import com.restaurante.microservicios.common.response.Response;

public class ConvertirApiResponse {

    public static ApiResponse  convertirApiResponse(Response response){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCodigo(response.getCodigo());
        apiResponse.setMensaje(response.getMensaje());
        apiResponse.setRespuesta(response.getRespuesta());
        return apiResponse;

    }
}
