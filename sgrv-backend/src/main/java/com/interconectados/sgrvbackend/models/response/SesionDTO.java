package com.interconectados.sgrvbackend.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SesionDTO {

    @JsonProperty(value = "estado")
    @JsonSetter("ESTADO")
    private int estado;
    @JsonProperty(value ="descripcion")
    @JsonSetter(value ="DESCRIPCION")
    private String descripcion;
    @JsonProperty(value ="sesion")
    @JsonSetter(value ="SESION")
    private String sesion;

    @Override
    public String toString(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e){
            return  "";
        }
    }

}
