package com.interconectados.sgrvbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class Redis {
    private final RedisTemplate<String, Object> redisTemplate;

    private String codigoAlmacen;
    @Autowired
    public Redis(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void guardarDato(String clave, Object valor) {
        redisTemplate.opsForValue().set(clave, valor);
    }

    public Object obtenerDato(String clave) {
        return redisTemplate.opsForValue().get(clave);
    }

    public void setCodAlmacen(String valor) {
        redisTemplate.opsForValue().set("codAlmacen", valor);
    }

    public String codAlmacen() {
        return redisTemplate.opsForValue().get("codAlmacen").toString();
    }

    public void setCodEntidad(String valor) {
        redisTemplate.opsForValue().set("codEntidad", valor);
    }

    public String codEntidad() {
        return redisTemplate.opsForValue().get("codEntidad").toString();
    }

    public void setCodPtoAtencion(String valor) {
        redisTemplate.opsForValue().set("codPtoAtencion", valor);
    }

    public String codPtoAtencion() {
        return redisTemplate.opsForValue().get("codPtoAtencion").toString();
    }

    public void setCodLocal(String valor) {
        redisTemplate.opsForValue().set("codLocal", valor);
    }

    public String codLocal() {
        return redisTemplate.opsForValue().get("codLocal").toString();
    }

    public void setSession(String valor) {
        redisTemplate.opsForValue().set("session", valor);
    }

    public String session() {
        return redisTemplate.opsForValue().get("session").toString();
    }

    public void setCodPersonal(String valor) {
        redisTemplate.opsForValue().set("codPersonal", valor);
    }

    public String codPersonal() {
        return redisTemplate.opsForValue().get("codPersonal").toString();
    }

    public void setCodPersona(String valor) {
        redisTemplate.opsForValue().set("codPersona", valor);
    }

    public String codPersona() {
        return redisTemplate.opsForValue().get("codPersona").toString();
    }

    public void setUsuario(String valor) {
        redisTemplate.opsForValue().set("usuario", valor);
    }

    public String usuario() {
        return redisTemplate.opsForValue().get("usuario").toString();
    }


}