package com.restaurante.microservicios.mscseguridad.repository;

import com.restaurante.microservicios.mscseguridad.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,String> {

    @Query(value = "{call SEGU.SQL_SESION(?,?,?,?,?,?,?)}", nativeQuery = true)
    Map<String, Object> validarUsuario(@Param("LITIPSQL") int tipoSQL,
                              @Param("LSUSUARI") String usuario, @Param("LSPASSWO") String password,
                              @Param("LSHOSNAM") String hostname, @Param("LSNUMEIP") String ip,
                              @Param("LSNUMMAC") String mac, @Param("LSFECSYS") String fechaSistema);

    @Query(value = "{call SEGU.CON_USUARIO(?,?,?,?)}", nativeQuery = true)
    Map<String, Object> obtenerPersonalUsuario(@Param("LITIPSQL") int tipoSQL,
                                               @Param("LSUSUARI") String usuario, @Param("LSPARAM1") String parametro1,
                                               @Param("LSPARAM2") String parametro2);
}
