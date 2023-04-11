package com.restaurante.microservicios.msccatalogo.repository;

import com.restaurante.microservicios.msccatalogo.entity.Entidad;
import com.restaurante.microservicios.msccatalogo.entity.EstadoRegistros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EntidadRepository extends JpaRepository<Entidad, Long> {
    @Query(value = "SELECT MAX(ENTIDAD) FROM ENTIDAD", nativeQuery = true)
    Long findMaxId();

}
