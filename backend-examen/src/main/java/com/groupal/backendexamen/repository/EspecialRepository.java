package com.groupal.backendexamen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.groupal.backendexamen.model.Especial;

@Repository
public interface EspecialRepository extends JpaRepository<Especial, Integer>{
	
}
