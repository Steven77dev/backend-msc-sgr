package com.restaurante.microservicios.mscpersonal.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class ApiResponseBuilder<T> {
    public ResponseEntity<ApiResponse> buildResponse(
            HttpHeaders httpHeader, int httpStatusCode, String message, T data, Map <String, Object> otherParams) {
        return new ApiResponse.ApiResponseBuilder <> (httpStatusCode, message).withHttpHeader(httpHeader)
                .withData(data).withOtherParams(otherParams).build();
    }

    public ResponseEntity <ApiResponse> buildResponse(
            int httpStatusCode, String message, T data, Map<String, Object> otherParams) {
        return new ApiResponse.ApiResponseBuilder <> (httpStatusCode, message)
                .withData(data).withOtherParams(otherParams).build();
    }

    public ResponseEntity <ApiResponse> buildResponse(
            int httpStatusCode, String message, Map <String, Object> otherParams) {
        return new ApiResponse.ApiResponseBuilder <> (httpStatusCode, message)
                .withOtherParams(otherParams).build();
    }

    public ResponseEntity <ApiResponse> errorResponse(
            int httpStatusCode, String message) {
        return new ApiResponse.ApiResponseBuilder <> (httpStatusCode, message)
               .build();
    }


    public ResponseEntity <ApiResponse> buildResponse(
            int httpStatusCode, String message) {
        return new ApiResponse.ApiResponseBuilder <> (httpStatusCode, message).build();
    }

    public ResponseEntity <ApiResponse> buildResponse(
            HttpHeaders httpHeader, int httpStatusCode, String message, T data) {
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
        return new ApiResponse.ApiResponseBuilder <T> (httpStatusCode, message)
                .withHttpHeader(httpHeader).build();
    }

    public ResponseEntity <ApiResponse> buildResponse(
            int httpStatusCode, String message, T data) {
        return new ApiResponse.ApiResponseBuilder <T> (httpStatusCode, message)
                .withData(data).build();
    }

    public ResponseEntity<ApiResponse> respuestaConExito( T data) {
        return new ApiResponse.ApiResponseBuilder <T> (HttpStatus.OK.value(), Constante.MENSAJE_EXITO)
                .withData(data).build();
    }

    public ResponseEntity<ApiResponse> respuestaConError(T data) {
        return new ApiResponse.ApiResponseBuilder <T> (HttpStatus.BAD_REQUEST.value(), Constante.MENSAJE_ERROR)
                .withData(data).build();
    }

    public ResponseEntity<ApiResponse> respuestaSinResultado(T data) {
        return new ApiResponse.ApiResponseBuilder <T> (HttpStatus.NOT_FOUND.value(), Constante.MENSAJE_SIN_RESULTADO)
                .withData(data).build();
    }


    public ResponseEntity<ApiResponse> exito(T data, Page<?> pageable) {
        return new ApiResponse.ApiResponseBuilder <T> (HttpStatus.OK.value(), Constante.MENSAJE_EXITO)
                .withData(data).withCount(pageable.getTotalPages(), (int) pageable.getTotalElements()).build();
    }

    public static ApiResponse desearializarApiResponse(String responseBody) throws IOException {
        // Crear un objeto ObjectMapper para deserializar la respuesta
        ObjectMapper mapper = new ObjectMapper();
        // Deserializar la respuesta a un objeto ApiResponse
        return mapper.readValue(responseBody, ApiResponse.class);
    }
}
