package com.restaurante.microservicios.mscpersonal.repository;

import com.restaurante.microservicios.mscpersonal.entity.Oficina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OficinaRepository extends JpaRepository<Oficina, Long> {

}
