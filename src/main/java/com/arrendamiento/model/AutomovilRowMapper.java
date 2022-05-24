package com.arrendamiento.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.arrendamiento.dto.AutomovilDto;

public class AutomovilRowMapper implements RowMapper<AutomovilDto> {

    @Override
    public AutomovilDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        
        AutomovilDto auto = new AutomovilDto();
        
        auto.setMarca(rs.getString("MARCA"));
        auto.setModelo(rs.getLong("MODELO"));
        auto.setPatente(rs.getString("PATENTE"));
        auto.setAnio(rs.getLong("ANIO"));
        auto.setKilometraje(rs.getLong("KILOMETRAJE"));
        auto.setCilindrada(rs.getLong("CILINDRADA"));
        auto.setTipo(rs.getString("TIPO"));
        auto.setPuertas(rs.getLong("PUERTAS"));
        auto.setPasajeros(rs.getLong("PASAJEROS"));
        auto.setCapacidadMaletero(rs.getLong("CAPACIDAD_MALETERO"));
        
        return auto;
    }

    
    
    
}
