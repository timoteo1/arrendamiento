package com.arrendamiento.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.arrendamiento.dao.MantencionesDao;
import com.arrendamiento.dao.VehiculoDao;
import com.arrendamiento.dto.MantencionDto;
import com.arrendamiento.dto.ResponseDto;

@Service
public class MantencionesService {
    
    VehiculoDao vehiculoDao;
    MantencionesDao mantencionesDao;
    ResponseService response;
   
    public MantencionesService(VehiculoDao vehiculoDao, MantencionesDao mantencionesDao, ResponseService response) {
        super();
        this.vehiculoDao = vehiculoDao;
        this.mantencionesDao = mantencionesDao;
        this.response = response;
    }

    public ResponseDto createMantencion(MantencionDto mantencion) {
        
        if(vehiculoDao.existVehiculo(mantencion.getPatente()) == 0)
            return response.setResponse(5, "");
            
        return mantencionesDao.createMantencion(mantencion);
    }
    
    public List<MantencionDto> getMantencion(String patente){
        
        return mantencionesDao.getMantencion(patente);
    }
    
    public ResponseDto deleteMantencion(String patente) {
        
        return mantencionesDao.deleteMantencion(patente);
    }
    
    public List<MantencionDto> getAllMantenciones(){
        
        return mantencionesDao.getAllMantenciones();
    }
    
    public ResponseDto updateMantencion(String patente, int id, MantencionDto mantencion) {
        
        return mantencionesDao.updateMantencion(patente, id, mantencion);
    }
    
}
