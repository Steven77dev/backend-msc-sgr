package com.restaurante.microservicios.msclogistica.service;

import com.restaurante.microservicios.msclogistica.dto.AreaDTO;
import com.restaurante.microservicios.msclogistica.entity.Area;
import com.restaurante.microservicios.msclogistica.repository.AreaRepository;
import com.restaurante.microservicios.msclogistica.utils.ApiResponse;
import com.restaurante.microservicios.msclogistica.utils.ResponseBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AreaService {

    private ResponseBuilder responseBuilder;
   private AreaRepository areaRepository;

   public AreaService(AreaRepository areaRepository, ResponseBuilder responseBuilder){
       this.areaRepository = areaRepository;
       this.responseBuilder = responseBuilder;
   }

    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> listado(){
        List<Area> listadoArea = areaRepository.findAll();
        List<AreaDTO> listadoDTO = new ArrayList<>();

        for(Area area : listadoArea){
            AreaDTO dto = new AreaDTO();
            dto.setId(area.getArea());
            dto.setAbreviatura(area.getAbreviatura());
            dto.setDescripcion(area.getDescripcion());
            listadoDTO.add(dto);
        }
        return listadoArea.isEmpty() ? responseBuilder.respuestaSinResultado(null) :  responseBuilder.respuestaConExito(listadoArea);

    }

    @Transactional(readOnly = true)
   public Area obtenerPorId(long id){
       Optional<Area> area = areaRepository.findById(id);
       if(area.isPresent()){
           return area.get();
       } else
           return new Area();
   }

    @Transactional
   public Area guardar(Area area){
        area.setArea(areaRepository.findMaxId()+1);
       return areaRepository.save(area);
   }

}
