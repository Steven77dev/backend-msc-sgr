package com.restaurante.microservicios.mscusuario.models.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class BusqCajaPorUsuarioRequest {
    @NotNull(message = "El usuario es requerido")
    private String usuario;
    @NotNull(message = "El local es requerido")
    private String local;
}
