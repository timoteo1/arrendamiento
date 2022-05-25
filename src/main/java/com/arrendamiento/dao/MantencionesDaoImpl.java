package com.arrendamiento.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.arrendamiento.dto.MantencionDto;
import com.arrendamiento.dto.ResponseDto;
import com.arrendamiento.model.MantencionRowMapper;
import com.arrendamiento.service.ResponseService;
import com.arrendamiento.util.MapeoQuery;

@Repository
public class MantencionesDaoImpl implements MantencionesDao {

    private final JdbcTemplate jdbcTemplate;
    VehiculoDaoImpl vehiculoDao;
    MapeoQuery mapeo;
    ResponseService response;
    
    public MantencionesDaoImpl(JdbcTemplate jdbcTemplate, VehiculoDaoImpl vehiculoDao, MapeoQuery mapeo, ResponseService r) {
        super();
        this.jdbcTemplate = jdbcTemplate;
        this.vehiculoDao = vehiculoDao;
        this.mapeo = mapeo;
        this.response = r;
    }

    @Override
    public ResponseDto createMantencion(MantencionDto mantencion) {
        try {
            String sql = "INSERT INTO mantenciones(KM, DETALLE, PATENTE_MANTENCION) VALUES (?,?,?)";
            
            int statusRequest = jdbcTemplate.update(sql, mantencion.getKm(), mantencion.getDetalle(), mantencion.getPatente());
            if(statusRequest == 1) {
                return response.setResponse(2);
            }
            return response.setResponse(3);
        } catch (Exception e) {
            return response.setResponseException(e.getMessage());
        }
    }

    @Override
    public List<MantencionDto> getMantencion(String patente) {
        String sql = "SELECT * FROM mantenciones WHERE PATENTE_MANTENCION = ?";
        return jdbcTemplate.query(sql, new MantencionRowMapper(), patente);
    }

    @Override
    public ResponseDto deleteMantencion(String patente) {         
        try {
            String sqlDelete = "DELETE FROM mantenciones WHERE PATENTE_MANTENCION = ?";
            int status = jdbcTemplate.update(sqlDelete, patente);
            if(status == 1) {
                return response.setResponse(2);
            }
            else {
                return response.setResponse(3);
            }
        } catch (Exception e) {
            return response.setResponseException(e.getMessage());      
       } 
    }

    @Override
    public List<MantencionDto> getAllMantenciones() {
        String sql = "SELECT * FROM mantenciones";
        
        return jdbcTemplate.query(sql, new MantencionRowMapper());       
    }

    @Override
    public ResponseDto updateMantencion(String patente, int id, MantencionDto mantencion) {
        String query = mapeo.DataUpdateMantencion(mantencion);
        if(!query.isEmpty()) {
            String sqlUpdateMantencion = String.format("UPDATE mantenciones SET %s WHERE PATENTE_MANTENCION = '%s' AND MANTENCIONES_ID = %s", query, patente, id);
            try {
                jdbcTemplate.update(sqlUpdateMantencion);
                return response.setResponse(2);
            } catch (Exception e) {
                return response.setResponseException(e.getMessage());
            } 
        }
        return response.setResponse(2);
    }
}
