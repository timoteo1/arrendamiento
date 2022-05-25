package com.arrendamiento.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.arrendamiento.dto.ResponseDto;

@Service
public class ResponseService {
    
    enum STATUS {
        ERROR, OK
    }
    
    public ResponseDto setResponse(int code) {
        switch (code) {
        case 1:
            return new ResponseDto(STATUS.ERROR.name(), 404, "Por favor ingrese dentro del body el campo tipoVehiculo");
        case 2:
            return new ResponseDto(STATUS.OK.name(), 200, "La operacion se realizo correctamente");
        case 3:
            return new ResponseDto(STATUS.ERROR.name(), 404, "La operacion no se pudo realizar, verifique los datos");
        case 4:
            return new ResponseDto(STATUS.ERROR.name(), 404, "El vehiculo no existe en la BD, no se puede realizar la operacion");
        case 5:
            return new ResponseDto(STATUS.ERROR.name(), 404, "El tipo de vehiculo ingresado no es valido");
        default:
            return null;
        }
    }
    
    public ResponseDto setResponseException(String message) {
        return new ResponseDto(STATUS.ERROR.name(), 404, message);
    }
}
