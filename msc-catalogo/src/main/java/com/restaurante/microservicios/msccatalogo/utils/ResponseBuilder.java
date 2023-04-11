package com.restaurante.microservicios.msccatalogo.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ResponseBuilder {
    public ResponseEntity<ApiResponse> buildResponse(
            HttpHeaders httpHeader, int httpStatusCode, String message, Object data, Map <String, Object> otherParams) {
        return new ApiResponse.ApiResponseBuilder <> (httpStatusCode, message).withHttpHeader(httpHeader)
                .withData(data).withOtherParams(otherParams).build();
    }

    public ResponseEntity <ApiResponse> buildResponse(
            int httpStatusCode, String message, Object data, Map<String, Object> otherParams) {
        return new ApiResponse.ApiResponseBuilder <> (httpStatusCode, message)
                .withData(data).withOtherParams(otherParams).build();
    }

    public ResponseEntity <ApiResponse> buildResponse(
            int httpStatusCode, String message, Map <String, Object> otherParams) {
        return new ApiResponse.ApiResponseBuilder <> (httpStatusCode, message)
                .withOtherParams(otherParams).build();
    }

    public ResponseEntity <ApiResponse> buildResponse(
            int httpStatusCode, String message) {
        return new ApiResponse.ApiResponseBuilder <> (httpStatusCode, message).build();
    }

    public ResponseEntity <ApiResponse> buildResponse(
            HttpHeaders httpHeader, int httpStatusCode, String message, Object data) {
        return new ApiResponse.ApiResponseBuilder <> (httpStatusCode, message)
                .withHttpHeader(httpHeader).withData(data).build();
    }

    public ResponseEntity <ApiResponse> buildResponse(
            HttpHeaders httpHeader, int httpStatusCode, String message, Map <String, Object> otherParams) {
        return new ApiResponse.ApiResponseBuilder <> (httpStatusCode, message)
                .withHttpHeader(httpHeader).withOtherParams(otherParams).build();
    }

    public ResponseEntity <ApiResponse> buildResponse(
            HttpHeaders httpHeader, int httpStatusCode, String message) {
        return new ApiResponse.ApiResponseBuilder <> (httpStatusCode, message)
                .withHttpHeader(httpHeader).build();
    }

    public ResponseEntity <ApiResponse> buildResponse(
            int httpStatusCode, String message, Object data) {
        return new ApiResponse.ApiResponseBuilder <> (httpStatusCode, message)
                .withData(data).build();
    }

    public ResponseEntity<ApiResponse> respuestaConExito( Object data) {
        return new ApiResponse.ApiResponseBuilder <> (HttpStatus.OK.value(), Constante.MENSAJE_EXITO)
                .withData(data).build();
    }

    public ResponseEntity<ApiResponse> respuestaConError(Object data) {
        return new ApiResponse.ApiResponseBuilder <> (HttpStatus.BAD_REQUEST.value(), Constante.MENSAJE_ERROR)
                .withData(data).build();
    }

    public ResponseEntity<ApiResponse> respuestaSinResultado(Object data) {
        return new ApiResponse.ApiResponseBuilder <> (HttpStatus.NOT_FOUND.value(), Constante.MENSAJE_SIN_RESULTADO)
                .withData(data).build();
    }
}
