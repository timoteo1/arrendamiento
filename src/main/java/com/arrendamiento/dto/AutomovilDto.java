package com.arrendamiento.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Data;
import lombok.EqualsAndHashCode;

@JsonTypeName("auto")
@EqualsAndHashCode(callSuper=false)
@Data
public class AutomovilDto extends VehiculoAbstractDto{
    
    private String tipo;
    private Long puertas;
    private Long pasajeros;
    private Long capacidadMaletero;
    
    public AutomovilDto()
    {
     super();
    }
    
    public AutomovilDto(String marca, Long modelo, String patente, Long anio, Long kilometraje, Long cilindrada, String tipoVehiculo, 
            Long puertas, Long pasajeros, Long capacidadMaletero) {
        super(tipoVehiculo, marca, modelo, patente, anio, kilometraje, cilindrada);
        this.tipo = tipoVehiculo;
        this.puertas = puertas;
        this.pasajeros = pasajeros;
        this.capacidadMaletero = capacidadMaletero;
    }
    
    @Override
    public String getMarca() {
        return super.getMarca();
    }
    
    @Override
    public Long getModelo() {
        return super.getModelo();
    }
    
    @Override
    public String getPatente() {
        return super.getPatente();
    }
    
    @Override
    public Long getAnio() {
        return super.getAnio();
    }
    
    @Override
    public Long getKilometraje() {
        return super.getKilometraje();
    }
    
    @Override
    public Long getCilindrada() {
        return super.getCilindrada();
    }
}