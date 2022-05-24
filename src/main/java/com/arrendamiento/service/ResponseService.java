package com.arrendamiento.service;

import org.springframework.stereotype.Service;

import com.arrendamiento.dto.ResponseDto;

@Service
public class ResponseService {
    
    public ResponseDto setResponse(int code, String message) {
        switch (code) {
        case 1:
            return new ResponseDto("ERROR", 404, "Por favor ingrese dentro del body el campo tipoVehiculo");
        case 2:
            return new ResponseDto("OK", 200, "La operacion se realizo correctamente");
        case 3:
            return new ResponseDto("ERROR", 404, "La operacion no se pudo realizar, verifique los datos");
        case 4:
            return new ResponseDto("ERROR", 404, message);
        case 5:
            return new ResponseDto("ERROR", 404, "El vehiculo no existe en la BD, no se puede realizar la operacion");
        case 6: 
            return new ResponseDto("ERROR", 404, "El tipo de vehiculo que se quiere crear no es valido");
        default:
            return null;
        }
    }
}
