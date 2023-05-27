package com.restaurante.microservicios.msccomercial.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SqlSPResponse {
    private String codigoRspta;
    private String param01;
}
