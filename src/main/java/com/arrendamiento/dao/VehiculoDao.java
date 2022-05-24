package com.arrendamiento.dao;

import com.arrendamiento.dto.ResponseDto;
import com.arrendamiento.dto.VehiculoAbstractDto;

public interface VehiculoDao {

    ResponseDto addVehiculo(VehiculoAbstractDto vehiculo);
    
    ResponseDto deleteVehiculo(String patente);
    
    ResponseDto updateVehiculo(VehiculoAbstractDto vehiculo, String patente);
    
    int existVehiculo(String patente);
}
