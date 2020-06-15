package com.groupal.backendexamen.service;

import java.util.List;

import com.groupal.backendexamen.dto.CompraComercioDto;

public interface ICompraComercioService {
	
	public CompraComercioDto save(CompraComercioDto compraComercioDto);
    
    public List<CompraComercioDto> findAll();
    
    public CompraComercioDto findById(Integer compraComercioId);
    
    public List<CompraComercioDto> findByUsuarioId(Integer usuarioId);
    
}
