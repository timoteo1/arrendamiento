package com.arrendamiento.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.arrendamiento.dao.AutomovilDao;
import com.arrendamiento.dao.CamionDao;
import com.arrendamiento.dao.VehiculoDao;
import com.arrendamiento.dto.AutomovilDto;
import com.arrendamiento.dto.CamionDto;
import com.arrendamiento.dto.ResponseDto;
import com.arrendamiento.dto.VehiculoAbstractDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class VehiculosService {
    
    AutomovilDao autoDao;
    CamionDao camionDao;
    VehiculoDao vehiculoDao;
    ResponseService response;
   
    public VehiculosService(AutomovilDao autoDao, CamionDao camionDao, VehiculoDao vehiculoDao,
            ResponseService response) {
        super();
        this.autoDao = autoDao;
        this.camionDao = camionDao;
        this.vehiculoDao = vehiculoDao;
        this.response = response;
    }

    public ResponseDto updateVehiculos(VehiculoAbstractDto vehiculo, String patente) throws JsonMappingException, JsonProcessingException {
        
        ObjectMapper mapper = new ObjectMapper();
        
        if(vehiculo.getTipoVehiculo() == null)
            return response.setResponse(1, "");
            
        if(vehiculoDao.existVehiculo(patente) == 0)
            return response.setResponse(5, "");
            
        switch (vehiculo.getTipoVehiculo()) {
        case "auto":
            ResponseDto status =vehiculoDao.updateVehiculo(vehiculo, patente);
            if(status.getCode() == 404) {
                return status;
            }else {
                AutomovilDto desAuto = mapper.readValue(mapper.writeValueAsString(vehiculo), AutomovilDto.class);
                return autoDao.updateAutomovil(desAuto, patente);
            }
        case "camion":
            ResponseDto statusVehiculo =vehiculoDao.updateVehiculo(vehiculo, patente);
            if(statusVehiculo.getCode() == 404) {
                return statusVehiculo;
            }else {
                CamionDto desCamion = mapper.readValue(mapper.writeValueAsString(vehiculo), CamionDto.class);
                return camionDao.updateCamion(desCamion, patente);
            }    
        default:
            return response.setResponse(3, "");
        }
    }
    
    public ResponseDto postNuevoVehiculo(VehiculoAbstractDto vehiculo)  throws JsonMappingException, JsonProcessingException {
        
        ObjectMapper mapper = new ObjectMapper();
        
        switch (vehiculo.getTipoVehiculo()) {
        case "auto":
            AutomovilDto desAuto = mapper.readValue(mapper.writeValueAsString(vehiculo), AutomovilDto.class);
            return autoDao.addAutomovil(desAuto);
            
        case "camion":
            CamionDto desCamion = mapper.readValue(mapper.writeValueAsString(vehiculo), CamionDto.class);
            return camionDao.addCamion(desCamion);
        default:
            return response.setResponse(6, "");
        }
    }
    
    public VehiculoAbstractDto getDataVehiculo(String patente, String tipo) {
        
        switch (tipo) {
        case "auto":
            return autoDao.getAutomovil(patente);
        case "camion":
            return camionDao.getCamion(patente);    
        default:
            return null;
       }
    }
    
    public ResponseDto deleteVehiculo(String patente) {
        if(vehiculoDao.existVehiculo(patente) == 0)
            return response.setResponse(5, "");
            
         return vehiculoDao.deleteVehiculo(patente);
    }
    
    public List<AutomovilDto> getAllVehicles(){
        
        return autoDao.getAllAutomovil();
        
    }
    
    public List<CamionDto> getAllCamiones(){
        
        return camionDao.getAllCamion();
        
    }    
}