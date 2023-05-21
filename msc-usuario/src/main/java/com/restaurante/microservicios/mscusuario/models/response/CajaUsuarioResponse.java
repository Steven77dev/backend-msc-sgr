package com.restaurante.microservicios.mscusuario.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CajaUsuarioResponse {

    @JsonProperty("caja")
    @JsonSetter("CAJA")
    private int caja;
    @JsonProperty("desCaja")
    @JsonSetter("DESCRIPCION")
    private String desCaja;
}
