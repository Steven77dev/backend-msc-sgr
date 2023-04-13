package com.restaurante.microservicios.mscpersonal.repository;

import com.restaurante.microservicios.mscpersonal.entity.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {
    @Query(value = "SELECT MAX(CARGO) FROM CARGO", nativeQuery = true)
    Long findMaxId();
}
