package com.restaurante.microservicios.mscpersonal.service;

import com.restaurante.microservicios.common.response.ApiResponse;
import com.restaurante.microservicios.common.response.ApiResponseBuilder;
import com.restaurante.microservicios.mscpersonal.entity.Cargo;
import com.restaurante.microservicios.mscpersonal.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CargoService {

    private CargoRepository cargoRepository;
    @Autowired
    private ApiResponseBuilder responseBuilder;


    public CargoService(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse<Object>> listado() {
        List<Cargo> lista = cargoRepository.findAll();
        if (lista.isEmpty()) return responseBuilder.respuestaSinResultado(null);
        return responseBuilder.respuestaConExito(lista);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse<Object>> obtenerPorId(long codigo) {
        Optional<Cargo> registro = cargoRepository.findById(codigo);
        if (registro.isPresent()) {
            return responseBuilder.respuestaConExito(registro.get());
        }
        return responseBuilder.respuestaSinResultado(null);

    }

    public ResponseEntity<ApiResponse<Object>> guardar(Cargo registro) {
        registro.setCargo(cargoRepository.findMaxId() + 1);
        registro.setCreacionFecha(new Date());
        cargoRepository.save(registro);
        return responseBuilder.respuestaConExito("0");
    }
}
