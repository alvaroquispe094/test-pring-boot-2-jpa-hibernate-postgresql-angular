package com.groupal.backendexamen.service;

import java.util.List;

import com.groupal.backendexamen.dto.UsuarioDto;

public interface IUsuarioService {
	
    public List<UsuarioDto> findAll();
    
    public List<UsuarioDto> findAllVip();
    
    public UsuarioDto findById(Integer usuarioId);
    
    public Boolean validarUsuarioVip(Integer usuarioId);
    
    public UsuarioDto save(UsuarioDto usuarioDto);
}
