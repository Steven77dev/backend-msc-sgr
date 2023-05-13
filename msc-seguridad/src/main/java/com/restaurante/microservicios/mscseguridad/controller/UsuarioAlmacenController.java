package com.restaurante.microservicios.mscseguridad.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Api-UsuarioAlmacen", description = "Servicios para el usuario relacionado al almacén")
@RestController
@RequestMapping("/usuario-almacen")
public class UsuarioAlmacenController {
}
