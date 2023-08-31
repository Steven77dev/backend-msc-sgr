package com.restaurante.microservicios.msccatalogo.repository;

import com.restaurante.microservicios.msccatalogo.entity.EstadoRegistros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRegistroRepository extends JpaRepository<EstadoRegistros, Long> {
    @Query(value = "SELECT MAX(ESTADO_REGISTRO) FROM SYST.ESTADO_REGISTROS", nativeQuery = true)
    Long findMaxId();

}
