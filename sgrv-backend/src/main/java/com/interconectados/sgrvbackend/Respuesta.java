package com.interconectados.sgrvbackend;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true, value = {"mapa", "lista"})
public class Respuesta extends Objeto {

    private static final long serialVersionUID = 1L;
    /* ========== CONSTRUCTOR ========== */
    public Respuesta() {
        setEstado("0");
    }

    /* ========== CONSTRUCTORES ESTATICOS ========== */
    public static Respuesta exito() {
        return new Respuesta();
    }

    public static Respuesta exito(String clave, Object valor) {
        Respuesta respuesta = new Respuesta();
        respuesta.set(clave, valor);
        return respuesta;
    }

    public static Respuesta estado(String estado) {
        return new Respuesta().setEstado(estado);
    }

    public static Respuesta error() {
        return Respuesta.estado("ERROR");
    }

    public static Respuesta parametrosIncorrectos() {
        return Respuesta.estado("PARAMETROS_INCORRECTOS");
    }

    /* ========== METODOS ========== */
    public Boolean hayError() {
        return !string("estado").equals("0");
    }

    public Respuesta set(String clave, Object valor) {
        super.set(clave, valor);
        return this;
    }

    public Respuesta setEstado(Object valor) {
        set("estado", valor);
        return this;
    }

    public Respuesta setEstadoExistenErrores() {
        return setEstado("EXISTEN_ERRORES");
    }

    public Respuesta ordenar(String... campos) {
        super.ordenar(campos);
        return this;
    }

    public Respuesta unir(Respuesta respuestaParcial) {
        for (String clave : respuestaParcial.claves()) {
            Object valor = respuestaParcial.get(clave);
            if ("estado".equals(clave) && !"0".equals(valor)) {
                setEstado(valor);
            } else {
                set(clave, valor);
            }
        }
        return this;
    }

}
