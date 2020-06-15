package com.groupal.backendexamen.service;

import java.util.List;

import com.groupal.backendexamen.dto.ProductoDto;

public interface IProductoService {
	
    public List<ProductoDto> findAll();
    
    public ProductoDto findById(Integer productoId);
    
}
