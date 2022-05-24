package com.arrendamiento.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arrendamiento.dto.AutomovilDto;
import com.arrendamiento.dto.CamionDto;
import com.arrendamiento.dto.MantencionDto;
import com.arrendamiento.dto.ResponseDto;
import com.arrendamiento.dto.VehiculoAbstractDto;
import com.arrendamiento.service.MantencionesService;
import com.arrendamiento.service.VehiculosService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.sun.istack.NotNull;

@RestController
@RequestMapping("/api")
public class ArrendamientoController {
    
    MantencionesService mService;
    VehiculosService service;

    public ArrendamientoController(MantencionesService mService, VehiculosService service) {
        super();
        this.mService = mService;
        this.service = service;
    }

    @PostMapping("/create/vehicle")
    private ResponseDto postNuevoVehiculo(@RequestBody VehiculoAbstractDto vehiculo) throws JsonProcessingException {
        
        return service.postNuevoVehiculo(vehiculo);
    }
    
    @GetMapping("/vehicle")
    private VehiculoAbstractDto getDataVehiculo(@NotNull @RequestParam String patente, @NotNull @RequestParam String tipo) {
        
        return service.getDataVehiculo(patente, tipo);
    }
    
    @GetMapping("/vehicle/allAutos")
    private List<AutomovilDto> getAllVehicles() {
        
            return service.getAllVehicles();
    }
    
    @GetMapping("/vehicle/allcamiones")
    private List<CamionDto> getAllCamiones() {
        
        return service.getAllCamiones();
    }
    
   @DeleteMapping("/vehicle/delete/{patente}")
   private ResponseDto deleteVehiculo(@NotNull @PathVariable String patente) {
        
       return service.deleteVehiculo(patente);
        
    }
   
   @PutMapping("/vehicle/update")
   private ResponseDto updateVehiculo(@NotNull @RequestParam String patente, @RequestBody VehiculoAbstractDto vehiculo) throws JsonMappingException, JsonProcessingException {
       
       return service.updateVehiculos(vehiculo, patente);
   }
   
   @PostMapping("/vehicle/mantencion")
   private ResponseDto createMantencion(@RequestBody MantencionDto mantencion){
       
       return mService.createMantencion(mantencion);
   }
   
   @GetMapping("/vehicle/mantencion/{patente}")
   private List<MantencionDto> getMantencion(@NotNull @PathVariable String patente) {
       
       return mService.getMantencion(patente);
   }
   
   @DeleteMapping("/vehicle/mantencion/{patente}")
   private ResponseDto deleteMantencion(@NotNull @PathVariable String patente) {
       
       return mService.deleteMantencion(patente); 

   }
   
   @GetMapping("/vehicle/mantencion/all")
   private List<MantencionDto> getAllMantenciones(){
       
       return mService.getAllMantenciones();
   }
   
   @PutMapping("/vehicle/mantencion/update")
   private ResponseDto updateMantencion(@NotNull @RequestParam String patente, @NotNull int id, @RequestBody MantencionDto mantencion) {
       
       return mService.updateMantencion(patente, id, mantencion);
   }
   
   
}
