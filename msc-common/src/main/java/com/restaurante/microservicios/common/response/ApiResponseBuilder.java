package com.restaurante.microservicios.common.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restaurante.microservicios.common.utils.Constante;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class ApiResponseBuilder<T> {
    public ResponseEntity<ApiResponse<T>> buildResponse(
            HttpHeaders httpHeader, int httpStatusCode, String message, T data, Map<String, Object> otherParams) {
        return new ApiResponse.ApiResponseBuilder<T>(httpStatusCode, message).withHttpHeader(httpHeader)
                .withData(data).withOtherParams(otherParams).build();
    }

    public ResponseEntity<ApiResponse<T>> buildResponse(
            int httpStatusCode, String message, T data, Map<String, Object> otherParams) {
        return new ApiResponse.ApiResponseBuilder<T>(httpStatusCode, message)
                .withData(data).withOtherParams(otherParams).build();
    }

    public ResponseEntity<ApiResponse<T>> buildResponse(
            int httpStatusCode, String message, Map<String, Object> otherParams) {
        return new ApiResponse.ApiResponseBuilder<T>(httpStatusCode, message)
                .withOtherParams(otherParams).build();
    }

    public ResponseEntity<ApiResponse<T>> errorResponse(
            int httpStatusCode, String message) {
        return new ApiResponse.ApiResponseBuilder<T>(httpStatusCode, message)
                .build();
    }


    public ResponseEntity<ApiResponse<T>> buildResponse(
            int httpStatusCode, String message) {
        return new ApiResponse.ApiResponseBuilder<T>(httpStatusCode, message).build();
    }

    public ResponseEntity<ApiResponse<T>> buildResponse(
            HttpHeaders httpHeader, int httpStatusCode, String message, T data) {
        return new ApiResponse.ApiResponseBuilder<T>(httpStatusCode, message)
                .withHttpHeader(httpHeader).withData(data).build();
    }

    public ResponseEntity<ApiResponse<T>> buildResponse(
            HttpHeaders httpHeader, int httpStatusCode, String message, Map<String, Object> otherParams) {
        return new ApiResponse.ApiResponseBuilder<T>(httpStatusCode, message)
                .withHttpHeader(httpHeader).withOtherParams(otherParams).build();
    }

    public ResponseEntity<ApiResponse<T>> buildResponse(
            HttpHeaders httpHeader, int httpStatusCode, String message) {
        return new ApiResponse.ApiResponseBuilder<T>(httpStatusCode, message)
                .withHttpHeader(httpHeader).build();
    }

    public ResponseEntity<ApiResponse<T>> buildResponse(
            int httpStatusCode, String message, T data) {
        return new ApiResponse.ApiResponseBuilder<T>(httpStatusCode, message)
                .withData(data).build();
    }

    public ResponseEntity<ApiResponse<T>> respuestaConExito(T data) {
        return new ApiResponse.ApiResponseBuilder<T>(HttpStatus.OK.value(), Constante.MENSAJE_EXITO)
                .withData(data).build();
    }

    public ResponseEntity<ApiResponse<T>> respuestaConError(T data) {
        return new ApiResponse.ApiResponseBuilder<T>(HttpStatus.BAD_REQUEST.value(), Constante.MENSAJE_ERROR)
                .withData(data).build();
    }

    public ResponseEntity<ApiResponse<T>> respuestaConErrorMicroservicio(T data) {
        return new ApiResponse.ApiResponseBuilder<T>(HttpStatus.SERVICE_UNAVAILABLE.value(), "Se presentó un problema al comunicarse con el microservicio.")
                .withData(data).build();
    }

    public ResponseEntity<ApiResponse<T>> respuestaSinResultado(T data) {
        return new ApiResponse.ApiResponseBuilder<T>(HttpStatus.NOT_FOUND.value(), Constante.MENSAJE_SIN_RESULTADO)
                .withData(data).build();
    }

    public ResponseEntity<ApiResponse<T>> exito(T data, Page<?> pageable) {
        return new ApiResponse.ApiResponseBuilder<T>(HttpStatus.OK.value(), Constante.MENSAJE_EXITO)
                .withData(data).withCount(pageable.getTotalPages(), (int) pageable.getTotalElements()).build();
    }

    public static ApiResponse<Object> desearializarApiResponse(String responseBody) {
        try {
            // Crear un objeto ObjectMapper para deserializar la respuesta
            ObjectMapper mapper = new ObjectMapper();
            // Deserializar la respuesta a un objeto ApiResponse
            return mapper.readValue(responseBody, ApiResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
