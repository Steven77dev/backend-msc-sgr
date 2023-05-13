package com.interconectados.sgrvbackend.utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import com.interconectados.sgrvbackend.Respuesta;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RespuestaHttpMessageConverter implements HttpMessageConverter<Respuesta> {

    private final MappingJackson2HttpMessageConverter delegate;

    public RespuestaHttpMessageConverter() {
        this.delegate = new MappingJackson2HttpMessageConverter();
        this.delegate.setObjectMapper(new ObjectMapper());
    }

    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return delegate.canRead(clazz, mediaType);
    }

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        return clazz.isAssignableFrom(Respuesta.class);
    }

    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return delegate.getSupportedMediaTypes();
    }

    @Override
    public Respuesta read(Class<? extends Respuesta> clazz, HttpInputMessage inputMessage)
            throws IOException {
        return delegate.getObjectMapper().readValue(inputMessage.getBody(), clazz);
    }

    @Override
    public void write(Respuesta t, MediaType contentType, HttpOutputMessage outputMessage)
            throws IOException {
        try {
            HttpHeaders headers = outputMessage.getHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
            delegate.write(t, MediaType.APPLICATION_JSON, outputMessage);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
