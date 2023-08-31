package com.restaurante.microservicios.msccatalogo.repository;

import com.restaurante.microservicios.msccatalogo.entity.Tarjeta;
import com.restaurante.microservicios.msccatalogo.entity.TarjetaPK;
import com.restaurante.microservicios.msccatalogo.models.response.TarjetaEntidadResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TarjetaRepository extends JpaRepository<Tarjeta, TarjetaPK> {
    //@Query(value = "SELECT MAX(TARJETA) FROM FINA.TARJETA", nativeQuery = true)
    //Long findMaxId();

    @Query("SELECT t.tarjeta as tarjeta, t.descripcion as descripcion FROM Tarjeta t where t.entidad = :entidad and t.estadoRegistro = :estadoRegistro")
    List<Map<String, Object>> findTarjetasByEntidadAndEstadoRegistro(@Param("entidad") int entidad, @Param("estadoRegistro") int estadoRegistro);

}
