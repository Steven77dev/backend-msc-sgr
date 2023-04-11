package com.restaurante.microservicios.mscpersona.repository;

import com.restaurante.microservicios.mscpersona.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository  extends JpaRepository<Persona, String> {
}
