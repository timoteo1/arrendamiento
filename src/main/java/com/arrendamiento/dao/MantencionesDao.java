package com.arrendamiento.dao;

import java.util.List;

import com.arrendamiento.dto.MantencionDto;
import com.arrendamiento.dto.ResponseDto;

public interface MantencionesDao {

    ResponseDto createMantencion(MantencionDto mantencion);
    
    List<MantencionDto> getMantencion(String patente);
    
    ResponseDto deleteMantencion(String patente);
    
    List<MantencionDto> getAllMantenciones();

    ResponseDto updateMantencion(String patente, int id, MantencionDto mantencion);
    
}
