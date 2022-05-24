package com.arrendamiento.dto;

import lombok.Data;

@Data
public class ResponseDto {
    
    private String status;
    private int code;
    private String detalle;
    
    public ResponseDto(String status, int code, String detalle) {
        this.status = status;
        this.code = code;
        this.detalle = detalle;
    }
    
}
