package com.arrendamiento.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.arrendamiento.dto.CamionDto;
import com.arrendamiento.dto.ResponseDto;
import com.arrendamiento.model.CamionRowMapper;
import com.arrendamiento.service.ResponseService;
import com.arrendamiento.util.MapeoQuery;

@Repository
public class CamionDaoImpl implements CamionDao {
    
    private final JdbcTemplate jdbcTemplate;
    VehiculoDaoImpl vehiculoDao;
    MapeoQuery mapeo;
    ResponseService response;
    
    public CamionDaoImpl(JdbcTemplate jdbcTemplate, VehiculoDaoImpl vehiculoDao, MapeoQuery mapeo, ResponseService r) {
        this.jdbcTemplate = jdbcTemplate;
        this.mapeo = mapeo;
        this.vehiculoDao = vehiculoDao;
        this.response = r;
    }

    @Override
    public ResponseDto addCamion(CamionDto camion) {
        
        try {
            ResponseDto status = vehiculoDao.addVehiculo(camion);
            if(status.getCode() == 200) {
                String sqlCamion = "INSERT INTO camion(TIPO, TONELAJE, EJES, PATENTE_CAMION)"
                        + "VALUES (?,?,?,?)";
                
                int statusRequest = jdbcTemplate.update(sqlCamion, camion.getTipoVehiculo(), camion.getTonelaje(), camion.getEjes(),
                        camion.getPatente());
                if(statusRequest == 1) {
                    return response.setResponse(2, ""); 
                }
            }
            return status;
        } catch (Exception e) {
           vehiculoDao.deleteVehiculo(camion.getPatente());
           return response.setResponse(4, e.getMessage());
        }
    }

    @Override
    public CamionDto getCamion(String patente) {
        
        String sql = "select v.*, c.* from vehiculo v inner join camion c ON v.PATENTE = c.PATENTE_CAMION WHERE v.patente = ?";
        List<CamionDto> salida = jdbcTemplate.query(sql, new CamionRowMapper(), patente);
        if(salida.size() > 0) {
            return salida.get(0);
        }
        return new CamionDto();        
    }

    @Override
    public List<CamionDto> getAllCamion() {
       
        String sql = "select v.*, c.* from vehiculo v inner join camion c ON v.PATENTE = c.PATENTE_CAMION";
        
        return jdbcTemplate.query(sql, new CamionRowMapper());
    }

    @Override
    public ResponseDto updateCamion(CamionDto camion, String patente) {
        String query = mapeo.DataUpdateCamion(camion);
        if(query != null) {
            String sqlUpdateCamion = "UPDATE camion SET " + query + " WHERE PATENTE_CAMION = '" + patente + "'";
            try {
                jdbcTemplate.update(sqlUpdateCamion);
                return response.setResponse(2, "");
            } catch (Exception e) {
                return response.setResponse(4, e.getMessage());
            } 
        }
        return response.setResponse(3, "");
    }
}