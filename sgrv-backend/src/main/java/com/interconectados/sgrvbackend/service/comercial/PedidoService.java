package com.interconectados.sgrvbackend.service.comercial;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.interconectados.sgrvbackend.Objeto;
import com.interconectados.sgrvbackend.models.request.*;
import com.interconectados.sgrvbackend.models.response.PedidoCreadoResponse;
import com.interconectados.sgrvbackend.service.Redis;
import com.interconectados.sgrvbackend.utils.ApiResponse;
import com.interconectados.sgrvbackend.utils.ConvertirApiResponse;
import com.restaurante.microservicios.common.response.Response;
import com.restaurante.microservicios.common.utils.Serializer;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    private final PedidoRest pedidoService;
    private static ObjectMapper objectMapper = Serializer.objectMapper();
    private final Redis redis;
    public PedidoService(PedidoRest pedidoService, Redis redis) {
        this.pedidoService = pedidoService;
        this.redis = redis;
    }

    public ApiResponse listadoMesasLocal(BusqMesasRequest request) {
        request.setLocal(Integer.parseInt(redis.obtenerDato("codLocal").toString()));
        request.setEntidad(Integer.parseInt(redis.obtenerDato("codEntidad").toString()));
        if(Objeto.anyEmpty(request.getLocal(), request.getEntidad(), request.getFecha()).booleanValue()){
            return ApiResponse.parametrosIncorrectos();
        }

        Response<?> responseEntity=  pedidoService.listadoMesasLocal(request);
        if (responseEntity.hayError()) return ApiResponse.error();
        else {
            return ConvertirApiResponse.exito(responseEntity);
        }
    }

    public ApiResponse listarPedidosPorMesa(BusqPedidosMesaRequest request) {
        request.setAlmacen(redis.obtenerDato("codAlmacen").toString());
        request.setEntidad(redis.obtenerDato("codEntidad").toString());
        if(Objeto.anyEmpty(request.getSeriePedido(), request.getEntidad(), request.getNroPedido(), request.getAlmacen()).booleanValue()){
            return ApiResponse.parametrosIncorrectos();
        }

        Response<?> responseEntity=  pedidoService.listarPedidosPorMesa(request);
        if (responseEntity.hayError()) {
            return ApiResponse.error();
        } else {
            return ConvertirApiResponse.exito(responseEntity);
        }
    }

    public ApiResponse agregarProductoPedido(AgregarProductoPedidoRequest request) {
        request.setEntidad(Integer.parseInt(redis.obtenerDato("codEntidad").toString()));
        if(Objeto.anyEmpty(request.getSeriePedido(),request.getEntidad(), request.getNroPedido(), request.getProducto()).booleanValue()){
            return ApiResponse.parametrosIncorrectos();
        }
        request.setSession(redis.obtenerDato("session").toString());
        Response<?> responseEntity=  pedidoService.agregarProductoPedido(request);
        if (responseEntity.hayError()) {
            return ApiResponse.error();
        } else {
            return ConvertirApiResponse.exito(responseEntity);
        }
    }

    public ApiResponse asignarMesaPedido(AsignarMesaPedidoRequest request) {
        request.setEntidad(Integer.parseInt(redis.codEntidad()));
        request.setLocal(Integer.parseInt(redis.codLocal()));
        if(Objeto.anyEmpty(request.getSeriePedido(), request.getEntidad(), request.getNroPedido(), request.getNroMesa(), request.getLocal()).booleanValue()){
            return ApiResponse.parametrosIncorrectos();
        }
        request.setSession(redis.obtenerDato("session").toString());
        Response<?> responseEntity=  pedidoService.asignarMesaPedido(request);
        if (responseEntity.hayError()) {
            return ApiResponse.error();
        } else {
            return ConvertirApiResponse.exito(responseEntity);
        }
    }

    public ApiResponse crearPedido(CrearPedidoRequest request) {
        request.setLocal(Integer.parseInt(redis.codLocal()));
        request.setPuntoAtencion(Integer.parseInt(redis.codPtoAtencion()));
        if(Objeto.anyEmpty(request.getPersonalAtencion(), request.getFechaIngreso(),request.getLocal(),request.getPuntoAtencion()).booleanValue()){
            return ApiResponse.parametrosIncorrectos();
        }
        request.setSession(redis.session());
        Response<?> responseEntity=  pedidoService.crearPedido(request);
        if (!responseEntity.hayError()) {
            PedidoCreadoResponse pedidoCreado = objectMapper.convertValue(responseEntity.getRespuesta(),PedidoCreadoResponse.class);
            AsignarMesaPedidoRequest asignarMesaPedidoRequest = request.getAsignarMesaPedido();
            asignarMesaPedidoRequest.setNroPedido(pedidoCreado.getNroPedido());
            asignarMesaPedidoRequest.setSeriePedido(pedidoCreado.getSeriePedido());
            asignarMesaPedidoRequest.setSession(redis.session());
            request.setAsignarMesaPedido(asignarMesaPedidoRequest);
            asignarMesaPedido(request.getAsignarMesaPedido());
            return  ConvertirApiResponse.exito(responseEntity);
        } else {
            return ApiResponse.error();
        }

    }
}
