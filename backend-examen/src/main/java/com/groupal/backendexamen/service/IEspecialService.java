package com.groupal.backendexamen.service;

import java.util.List;

import com.groupal.backendexamen.dto.EspecialDto;

public interface IEspecialService {
	
    public List<EspecialDto> findAll();
    
    public EspecialDto findById(Integer compraComercioId);
    
}
