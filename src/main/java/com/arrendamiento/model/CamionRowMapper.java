package com.arrendamiento.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.arrendamiento.dto.CamionDto;

public class CamionRowMapper implements RowMapper<CamionDto> {

    @Override
    public CamionDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        
        CamionDto camion = new CamionDto();
        
        camion.setMarca(rs.getString("MARCA"));
        camion.setModelo(rs.getLong("MODELO"));
        camion.setPatente(rs.getString("PATENTE"));
        camion.setAnio(rs.getLong("ANIO"));
        camion.setKilometraje(rs.getLong("KILOMETRAJE"));
        camion.setCilindrada(rs.getLong("CILINDRADA"));
        camion.setTipo(rs.getString("TIPO"));
        camion.setEjes(rs.getLong("EJES"));
        camion.setTonelaje(rs.getLong("TONELAJE"));
        
        return camion;
    }

}
