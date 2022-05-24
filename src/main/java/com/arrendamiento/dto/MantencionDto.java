package com.arrendamiento.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MantencionDto {

    private Long km;
    private String detalle;
    private String patente;
    
}
