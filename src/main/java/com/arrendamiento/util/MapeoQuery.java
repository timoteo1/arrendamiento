package com.arrendamiento.util;

import org.springframework.stereotype.Component;

import com.arrendamiento.dto.AutomovilDto;
import com.arrendamiento.dto.CamionDto;
import com.arrendamiento.dto.MantencionDto;
import com.arrendamiento.dto.VehiculoAbstractDto;

@Component
public class MapeoQuery {
    
    public String DataUpdateVehiculo(VehiculoAbstractDto auto) {
        
        String query = "";
        
        query = (auto.getPatente() != null) ? "PATENTE = '" + auto.getPatente() + "',": query;
        query = (auto.getModelo() != null) ? query + "MODELO = " + auto.getTipoVehiculo() + ",": query;
        query = (auto.getAnio() != null) ? query + "ANIO = " + auto.getAnio() + ",": query;
        query = (auto.getKilometraje() != null) ? query + "KILOMETRAJE = " + auto.getKilometraje() + ",": query;
        query = (auto.getMarca() != null) ? query + "MARCA = '" + auto.getMarca() + "',": query;
        query = (auto.getCilindrada() != null) ? query + "CILINDRADA = " + auto.getCilindrada() + ",": query;
        
        if(query!="") {
            query = query.substring(0, query.length()-1);
            return query;
        }
        return null;        
    }
    
    public String DataUpdateAutomovil(AutomovilDto auto) {
        
        String query = "";
        
        query = (auto.getTipo() != null) ? query + "TIPO = '" + auto.getTipo() + "',": query;
        query = (auto.getPuertas() != null) ? query + "PUERTAS = " + auto.getPuertas() + ",": query;
        query = (auto.getPasajeros() != null) ? query + "PASAJEROS = " + auto.getPasajeros() + ",": query;
        query = (auto.getCapacidadMaletero() != null) ? query + "CAPACIDAD_MALETERO = " + auto.getCapacidadMaletero() + ",": query;

        if(query!="") {
            query = query.substring(0, query.length()-1);
            return query;
        }
        return null;
    }
    
    public String DataUpdateCamion(CamionDto camion) {
        
        String query = "";
        
        query = (camion.getTipo() != null) ? query + "TIPO = '" + camion.getTipo() + "',": query;
        query = (camion.getTonelaje() != null) ? query + "TONELAJE = " + camion.getTonelaje() + ",": query;
        query = (camion.getEjes() != null) ? query + "EJES = " + camion.getEjes() + ",": query;
        
        if(query!="") {
            query = query.substring(0, query.length()-1);
            return query;
        }
        return null;
    }
    
    public String DataUpdateMantencion(MantencionDto mantencion) {
        
        String query = "";
        
        query = (mantencion.getPatente() != null) ? query + "PATENTE_MANTENCION = '" + mantencion.getPatente() + "',": query;
        query = (mantencion.getDetalle() != null) ? query + "DETALLE = '" + mantencion.getDetalle() + "',": query;
        query = (mantencion.getKm() != null) ? query + "KM = " + mantencion.getKm() + ",": query;
        
        if(query!="") {
            query = query.substring(0, query.length()-1);
            return query;
        }
        return null;
        
    }

}
