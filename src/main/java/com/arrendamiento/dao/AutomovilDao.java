package com.arrendamiento.dao;

import java.util.List;

import com.arrendamiento.dto.AutomovilDto;
import com.arrendamiento.dto.ResponseDto;

public interface AutomovilDao {

    ResponseDto addAutomovil(AutomovilDto auto);
    
    ResponseDto updateAutomovil(AutomovilDto auto, String Patente);
    
    AutomovilDto getAutomovil(String patente);
    
    List<AutomovilDto> getAllAutomovil();
}
