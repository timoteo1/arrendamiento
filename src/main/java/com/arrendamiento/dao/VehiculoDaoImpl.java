package com.arrendamiento.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.arrendamiento.dto.ResponseDto;
import com.arrendamiento.dto.VehiculoAbstractDto;
import com.arrendamiento.service.ResponseService;
import com.arrendamiento.util.MapeoQuery;

@Repository
public class VehiculoDaoImpl implements VehiculoDao {

    private final JdbcTemplate jdbcTemplate;
    MapeoQuery mapeo;
    ResponseService response;
    
    public VehiculoDaoImpl(JdbcTemplate jdbcTemplate, MapeoQuery mapeo, ResponseService response) {
        super();
        this.jdbcTemplate = jdbcTemplate;
        this.mapeo = mapeo;
        this.response = response;
    }
    
    @Override
    public ResponseDto addVehiculo(VehiculoAbstractDto vehiculo) {
        try {
            String sqlVehiculo = "INSERT INTO vehiculo(PATENTE, MODELO, ANIO, KILOMETRAJE, MARCA, CILINDRADA) "
                    + "VALUES (?,?,?,?,?,?)";
            
            int status =  jdbcTemplate.update(sqlVehiculo, vehiculo.getPatente(), vehiculo.getModelo(), 
                    vehiculo.getAnio(), vehiculo.getKilometraje(), vehiculo.getMarca(), vehiculo.getCilindrada());
            if(status == 1) {
                return response.setResponse(2);
            }
            return response.setResponse(3);
        } catch (Exception e) {
            return response.setResponseException(e.getMessage());
        } 
    }

    @Override
    public ResponseDto deleteVehiculo(String patente) {
        try {
            String sqlDelete = "DELETE FROM vehiculo WHERE patente = ?";
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
    public ResponseDto updateVehiculo(VehiculoAbstractDto vehiculo, String patente) {
        String query = mapeo.DataUpdateVehiculo(vehiculo);
        if(!query.isEmpty()) {
            String sqlUpdateVehicle = String.format("UPDATE vehiculo SET %s WHERE PATENTE = '%S'", query, patente);
            query = null;
            try {
                jdbcTemplate.update(sqlUpdateVehicle);
                return response.setResponse(2);
            } catch (Exception e) {
                return response.setResponseException(e.getMessage());
            } 
        }
        return response.setResponse(2);
    }

    @Override
    public int existVehiculo(String patente) {
        String sql = String.format("select count(*) from vehiculo where patente = '%s'",patente);
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

   

}
