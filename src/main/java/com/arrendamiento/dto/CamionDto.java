package com.arrendamiento.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Data;

@JsonTypeName("camion")
@Data
public class CamionDto extends VehiculoAbstractDto{

    private String tipo;
    private Long tonelaje;
    private Long ejes;
    
    public CamionDto(String marca, Long modelo, String patente, Long anio, Long kilometraje, Long cilindrada, String tipoVehiculo,
            Long tonelaje, Long ejes) {
        super(tipoVehiculo, marca, modelo, patente, anio, kilometraje, cilindrada);
        
        this.tipo = tipoVehiculo;
        this.tonelaje = tonelaje;
        this.ejes = ejes;
    }

    public CamionDto() {
        super();
        // TODO Auto-generated constructor stub
    }
    
}
