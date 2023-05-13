package com.restaurante.microservicios.mscseguridad.models.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class UsuarioRequest {
    @NotNull(message = "El usuario es requerido")
    private String usuario;
    @NotNull(message = "La contraseña es requerida")
    private String password;
    private String ip;
}
