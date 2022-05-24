package com.arrendamiento.dto;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, 
property = "tipoVehiculo", visible = true)
@JsonSubTypes({
    @Type(value = AutomovilDto.class, name = "auto"),
    @Type(value = CamionDto.class, name = "camion")
})
@JsonInclude(NON_NULL)
public abstract class VehiculoAbstractDto {
    
    private String tipoVehiculo;
    private String marca;
    private Long modelo;
    private String patente;
    private Long anio;
    private Long kilometraje;
    private Long cilindrada;
    
}
