package com.restaurante.microservicios.mscseguridad.config;

import com.fasterxml.jackson.databind.module.SimpleModule;
import org.hibernate.proxy.HibernateProxy;

public class LazyLoadingModule extends SimpleModule {

    public LazyLoadingModule() {
        addSerializer(HibernateProxy.class, new HibernateProxySerializer());
    }

}