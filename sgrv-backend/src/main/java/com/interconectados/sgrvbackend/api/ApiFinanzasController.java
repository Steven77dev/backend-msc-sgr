package com.interconectados.sgrvbackend.api;

import com.interconectados.sgrvbackend.models.request.BusqAperturaCierreRequest;
import com.interconectados.sgrvbackend.service.finanzas.IngresoDiarioService;
import com.interconectados.sgrvbackend.utils.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/finanzas")
public class ApiFinanzasController {

    private final IngresoDiarioService ingresoDiarioService;

    public ApiFinanzasController(IngresoDiarioService ingresoDiarioService){
        this.ingresoDiarioService = ingresoDiarioService;
    }

    @PostMapping(value = "/verificarAperturaCaja", produces = MediaType.APPLICATION_JSON_VALUE)
    ApiResponse verificarAperturaCaja(@RequestBody BusqAperturaCierreRequest request){
        return ingresoDiarioService.verificarAperturaCaja(request);
    }
}
