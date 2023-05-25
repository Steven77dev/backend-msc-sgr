package com.interconectados.sgrvbackend.service;

import com.interconectados.sgrvbackend.Objeto;
import com.interconectados.sgrvbackend.models.request.BusqMesasRequest;
import com.interconectados.sgrvbackend.models.request.BusqPedidosMesaRequest;
import com.interconectados.sgrvbackend.models.request.UsuarioRequest;
import com.interconectados.sgrvbackend.utils.ApiResponse;
import com.interconectados.sgrvbackend.utils.ConvertirApiResponse;
import com.restaurante.microservicios.common.response.Response;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl {

    private final PedidoService pedidoService;

    public PedidoServiceImpl(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    public ApiResponse listadoMesasLocal(BusqMesasRequest request) {

        if(Objeto.anyEmpty(request.getLocal(), request.getEntidad(), request.getFecha())){
            return ApiResponse.parametrosIncorrectos();
        }

        Response responseEntity=  pedidoService.listadoMesasLocal(request).getBody();
        if (responseEntity.hayError()) {
            return ApiResponse.error();
        } else {
            return ConvertirApiResponse.exito(responseEntity);
        }
    }

    public ApiResponse listarPedidosPorMesa(BusqPedidosMesaRequest request) {

        if(Objeto.anyEmpty(request.getSeriePedido(), request.getEntidad(), request.getNroPedido(), request.getAlmacen())){
            return ApiResponse.parametrosIncorrectos();
        }

        Response responseEntity=  pedidoService.listarPedidosPorMesa(request).getBody();
        if (responseEntity.hayError()) {
            return ApiResponse.error();
        } else {
            return ConvertirApiResponse.exito(responseEntity);
        }
    }
}
