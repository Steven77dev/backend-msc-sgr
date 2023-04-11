package com.restaurante.microservicios.mscpersonal.repository;

import com.restaurante.microservicios.mscpersonal.entity.Personal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalRepository extends JpaRepository<Personal, String> {
}
