package com.groupal.backendexamen.service;

import java.util.List;

import com.groupal.backendexamen.dto.CompraComercioDto;
import com.groupal.backendexamen.dto.ProductoDto;
import com.groupal.backendexamen.dto.ShoppingCartDto;

public interface IShoppingCartService {
	
	public CompraComercioDto save(ShoppingCartDto shoppinCartDto);
    
    public List<ShoppingCartDto> findAll();
    
    public ShoppingCartDto findById(Integer shoppinCartDtoId);
    
    public ShoppingCartDto checkout(List<ProductoDto> checkoutList, Integer usuarioId);
    
}
