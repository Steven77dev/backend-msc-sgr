package com.restaurante.microservicios.msccatalogo.utils;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.Map;

@JsonPropertyOrder({ "headers", "codigo", "mensaje", "respuesta", "otrosParams" })
@Getter
public class ApiResponse<T> {

    private final HttpHeaders headers;
    private final int codigo;
    private final String mensaje;
    private final T respuesta;
    private final Map<String, Object> otrosParams;

    private ApiResponse(ApiResponseBuilder builder) {
        this.headers = builder.headers;
        this.codigo = builder.codigo;
        this.mensaje = builder.mensaje;
        this.respuesta = (T) builder.respuesta;
        this.otrosParams = builder.otrosParams;
    }



    public static class ApiResponseBuilder<T> {

        private HttpHeaders headers = new HttpHeaders();
        private final int codigo;
        private final String mensaje;
        private T respuesta;
        private Map<String, Object> otrosParams = Collections.emptyMap();


        public ApiResponseBuilder(int httpStatusCode, String message) {
            this.codigo = httpStatusCode;
            this.mensaje = message;
        }

        public ApiResponseBuilder<T> withHttpHeader(HttpHeaders httpHeader) {
            this.headers = httpHeader;
            return this;
        }

        public ApiResponseBuilder<T> withData(T respuesta) {
            this.respuesta = respuesta;
            return this;
        }

        public ApiResponseBuilder<T> withOtherParams(Map<String, Object> otherParams) {
            this.otrosParams = otherParams;
            return this;
        }

        public ResponseEntity<ApiResponse> build() {
            ApiResponse<T> apiResponse = new ApiResponse<>(this);
            return ResponseEntity.status(apiResponse.getCodigo()).headers(apiResponse.getHeaders())
                    .body(apiResponse);
        }
    }
}