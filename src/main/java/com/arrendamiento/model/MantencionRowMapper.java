package com.arrendamiento.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.arrendamiento.dto.MantencionDto;

public class MantencionRowMapper implements RowMapper<MantencionDto> {

    @Override
    public MantencionDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        
        MantencionDto m = new MantencionDto();
        
        m.setDetalle(rs.getString("DETALLE"));
        m.setKm(rs.getLong("KM"));
        m.setPatente(rs.getString("PATENTE_MANTENCION"));
        
        return m;
    }

}
