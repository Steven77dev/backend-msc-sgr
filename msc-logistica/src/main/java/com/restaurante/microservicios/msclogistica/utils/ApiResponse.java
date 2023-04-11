package com.restaurante.microservicios.msclogistica.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.Map;

@JsonPropertyOrder({ "headers", "codigo", "mensaje","totalPaginas","totalRegistros", "respuesta", "otrosParams" })
@Getter
public class ApiResponse<T> {

    private final HttpHeaders headers;
    private final int codigo;
    private final String mensaje;
    @JsonIgnore
    private final long totalRegistros;
    @JsonIgnore
    private final long totalPaginas;
    private final T respuesta;
    @JsonIgnore
    private final Map<String, Object> otrosParams;

    private ApiResponse(ApiResponseBuilder builder) {
        this.headers = builder.headers;
        this.codigo = builder.codigo;
        this.mensaje = builder.mensaje;
        this.totalPaginas = builder.totalPaginas;
        this.totalRegistros = builder.totalRegistros;
        this.respuesta = (T) builder.respuesta;
        this.otrosParams = builder.otrosParams;
    }



    public static class ApiResponseBuilder<T> {

        private HttpHeaders headers = new HttpHeaders();
        private final int codigo;
        private final String mensaje;
        private  long totalRegistros;
        private  long totalPaginas;
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

        public ApiResponseBuilder<T> withCount(long totalPaginas, long totalRegistros) {
            this.totalPaginas = totalPaginas;
            this.totalRegistros = totalRegistros;
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