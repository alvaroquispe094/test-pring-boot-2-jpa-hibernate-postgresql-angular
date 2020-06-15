package com.groupal.backendexamen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.groupal.backendexamen.model.CompraComercio;

@Repository
public interface CompraComercioRepository extends JpaRepository<CompraComercio, Integer>{
	
	public List<CompraComercio> findByUsuarioId(Integer usuarioId);
	
}

