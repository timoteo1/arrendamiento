package com.arrendamiento.dao;

import java.util.List;

import com.arrendamiento.dto.CamionDto;
import com.arrendamiento.dto.ResponseDto;

public interface CamionDao {
    
    ResponseDto addCamion(CamionDto camion);
    
    CamionDto getCamion(String patente);
    
    List<CamionDto> getAllCamion();
    
    ResponseDto updateCamion(CamionDto camion, String patente);
}
