package com.restaurante.microservicios.mscpersonal.service;

import com.restaurante.microservicios.mscpersonal.entity.Cargo;
import com.restaurante.microservicios.mscpersonal.repository.CargoRepository;
import com.restaurante.microservicios.mscpersonal.utils.ApiResponse;
import com.restaurante.microservicios.mscpersonal.utils.ApiResponseBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CargoService {

    private CargoRepository cargoRepository;
    private final ApiResponseBuilder<Object> responseBuilder;


    public CargoService(CargoRepository cargoRepository, ApiResponseBuilder<Object> responseBuilder) {
        this.cargoRepository = cargoRepository;
        this.responseBuilder = responseBuilder;
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
