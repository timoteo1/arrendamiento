package com.arrendamiento.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.arrendamiento.dto.AutomovilDto;
import com.arrendamiento.dto.ResponseDto;
import com.arrendamiento.model.AutomovilRowMapper;
import com.arrendamiento.service.ResponseService;
import com.arrendamiento.util.MapeoQuery;

@Repository
public class AutomovilDaoImpl implements AutomovilDao {

    private final JdbcTemplate jdbcTemplate;
    VehiculoDaoImpl vehiculoDao;
    MapeoQuery mapeo;
    ResponseService response;
    
    public AutomovilDaoImpl(JdbcTemplate jdbcTemplate, VehiculoDaoImpl vehiculoDao, MapeoQuery mapeo,
            ResponseService response) {
        super();
        this.jdbcTemplate = jdbcTemplate;
        this.vehiculoDao = vehiculoDao;
        this.mapeo = mapeo;
        this.response = response;
    }

    @Autowired
    public AutomovilDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Override
    public ResponseDto addAutomovil(AutomovilDto auto) {
        try {
            ResponseDto status = vehiculoDao.addVehiculo(auto);
            if(status.getCode() == 200) {
                String sqlAutomovil = "INSERT INTO automovil(TIPO, PUERTAS, PASAJEROS, CAPACIDAD_MALETERO, PATENTE_AUTOMOVIL) "
                        + "VALUES (?,?,?,?,?)";
                
                int statusRequest = jdbcTemplate.update(sqlAutomovil, auto.getTipoVehiculo(), auto.getPuertas(), auto.getPasajeros(), auto.getCapacidadMaletero(),
                        auto.getPatente());
                if(statusRequest == 1) {
                    return response.setResponse(2, "");
                }
            }
            return status;
        } catch (Exception e) {
           vehiculoDao.deleteVehiculo(auto.getPatente());
           return response.setResponse(4, e.getMessage());
        }
    }

    @Override
    public AutomovilDto getAutomovil(String patente) {
        
        String sql = "select v.*, a.* from vehiculo v inner join automovil a ON v.PATENTE = a.PATENTE_AUTOMOVIL where v.patente = ?";        
        List<AutomovilDto> salida = jdbcTemplate.query(sql, new AutomovilRowMapper(), patente);
        
        if(salida.size() > 0)
            return salida.get(0);
        else
            return new AutomovilDto();        
    }

    @Override
    public List<AutomovilDto> getAllAutomovil() {
        
        String sql = "select v.*, a.* from vehiculo v INNER JOIN automovil a ON v.PATENTE = a.PATENTE_AUTOMOVIL";
        
        return jdbcTemplate.query(sql, new AutomovilRowMapper());
    }

    @Override
    public ResponseDto updateAutomovil(AutomovilDto auto, String patente) {
        
        String query = mapeo.DataUpdateAutomovil(auto);
        if(query != null) {
            String sqlUpdateAutomovil = "UPDATE automovil SET" + query + "WHERE PATENTE_AUTOMOVIL = " + patente;
            try {
                jdbcTemplate.update(sqlUpdateAutomovil);
                return response.setResponse(2, "");
            } catch (Exception e) {
                return response.setResponse(4, e.getMessage());
            } 
        }
        return response.setResponse(3, "");
    }
 }