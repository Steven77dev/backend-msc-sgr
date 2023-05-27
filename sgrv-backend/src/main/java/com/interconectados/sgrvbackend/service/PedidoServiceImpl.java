package com.interconectados.sgrvbackend.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.interconectados.sgrvbackend.Objeto;
import com.interconectados.sgrvbackend.models.request.*;
import com.interconectados.sgrvbackend.models.response.PedidoCreadoResponse;
import com.interconectados.sgrvbackend.utils.ApiResponse;
import com.interconectados.sgrvbackend.utils.ConvertirApiResponse;
import com.restaurante.microservicios.common.response.Response;
import com.restaurante.microservicios.common.utils.Serializer;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl {

    private final PedidoService pedidoService;
    private static ObjectMapper objectMapper = Serializer.objectMapper();

    public PedidoServiceImpl(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    public ApiResponse listadoMesasLocal(BusqMesasRequest request) {

        if(Objeto.anyEmpty(request.getLocal(), request.getEntidad(), request.getFecha()).booleanValue()){
            return ApiResponse.parametrosIncorrectos();
        }

        Response<?> responseEntity=  pedidoService.listadoMesasLocal(request).getBody();
        if (responseEntity.hayError()) return ApiResponse.error();
        else {
            return ConvertirApiResponse.exito(responseEntity);
        }
    }

    public ApiResponse listarPedidosPorMesa(BusqPedidosMesaRequest request) {

        if(Objeto.anyEmpty(request.getSeriePedido(), request.getEntidad(), request.getNroPedido(), request.getAlmacen()).booleanValue()){
            return ApiResponse.parametrosIncorrectos();
        }

        Response<?> responseEntity=  pedidoService.listarPedidosPorMesa(request).getBody();
        if (responseEntity.hayError()) {
            return ApiResponse.error();
        } else {
            return ConvertirApiResponse.exito(responseEntity);
        }
    }

    public ApiResponse agregarProductoPedido(AgregarProductoPedidoRequest request) {

        if(Objeto.anyEmpty(request.getSeriePedido(), request.getEntidad(), request.getNroPedido(), request.getProducto()).booleanValue()){
            return ApiResponse.parametrosIncorrectos();
        }

        Response<?> responseEntity=  pedidoService.agregarProductoPedido(request).getBody();
        if (responseEntity.hayError()) {
            return ApiResponse.error();
        } else {
            return ConvertirApiResponse.exito(responseEntity);
        }
    }

    public ApiResponse asignarMesaPedido(AsignarMesaPedidoRequest request) {

        if(Objeto.anyEmpty(request.getSeriePedido(), request.getEntidad(), request.getNroPedido(), request.getNroMesa(), request.getLocal()).booleanValue()){
            return ApiResponse.parametrosIncorrectos();
        }

        Response<?> responseEntity=  pedidoService.asignarMesaPedido(request).getBody();
        if (responseEntity.hayError()) {
            return ApiResponse.error();
        } else {
            return ConvertirApiResponse.exito(responseEntity);
        }
    }

    public ApiResponse crearPedido(CrearPedidoRequest request) {
        if(Objeto.anyEmpty(request.getPersonalAtencion(), request.getFechaIngreso(), request.getLocal(), request.getPuntoAtencion()).booleanValue()){
            return ApiResponse.parametrosIncorrectos();
        }

        Response<?> responseEntity=  pedidoService.crearPedido(request).getBody();
        if (!responseEntity.hayError()) {
            PedidoCreadoResponse pedidoCreado = objectMapper.convertValue(responseEntity.getRespuesta(),PedidoCreadoResponse.class);
            AsignarMesaPedidoRequest asignarMesaPedidoRequest = request.getAsignarMesaPedido();
            asignarMesaPedidoRequest.setNroPedido(pedidoCreado.getNroPedido());
            asignarMesaPedidoRequest.setSeriePedido(pedidoCreado.getSeriePedido());
            request.setAsignarMesaPedido(asignarMesaPedidoRequest);
            asignarMesaPedido(request.getAsignarMesaPedido());
            return  ConvertirApiResponse.exito(responseEntity);
        } else {
            return ApiResponse.error();
        }

    }
}
