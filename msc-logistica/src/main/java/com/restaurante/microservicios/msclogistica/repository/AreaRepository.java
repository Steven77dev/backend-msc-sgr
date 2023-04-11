package com.restaurante.microservicios.msclogistica.repository;


import com.restaurante.microservicios.msclogistica.entity.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaRepository extends JpaRepository<Area,Long> {

    @Query(value = "SELECT MAX(AREA) FROM AREA", nativeQuery = true)
    Long findMaxId();
}
