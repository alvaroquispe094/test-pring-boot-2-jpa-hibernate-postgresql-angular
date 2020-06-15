package com.groupal.backendexamen.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupal.backendexamen.dto.EspecialDto;
import com.groupal.backendexamen.model.Especial;
import com.groupal.backendexamen.repository.EspecialRepository;
import com.groupal.backendexamen.utils.ResourceNotFoundException;

@Service
public class EspecialService implements IEspecialService{

	@Autowired
	EspecialRepository especialRepository;
	
	@Override
	public List<EspecialDto> findAll() {
	
		List<Especial> listDb = especialRepository.findAll();
		
		if (listDb.isEmpty()) {
			 return null;
	     }
		List<EspecialDto> list = new ArrayList<EspecialDto>();
		
		for(Especial especial: listDb) {
			EspecialDto especialDto = new EspecialDto();
			//setear datos de la entity en el dto
			especialDto.setId(especial.getId());
			especialDto.setFecha(especial.getFecha());
			especialDto.setActivo(especial.getActivo());
			list.add(especialDto);
		}
		return list;
		
	}

	@Override
	public EspecialDto findById(Integer especialId) {
		
		Optional<Especial> especialDb = especialRepository.findById(especialId);
	 	
		if (!especialDb.isPresent()) {
			throw new ResourceNotFoundException("Record not found with id : " + especialId);
		}
      
		EspecialDto especialDto = new EspecialDto();
		//setear los datos en el dto
		especialDto.setId(especialDb.get().getId());
	    especialDto.setFecha(especialDb.get().getFecha());
		especialDto.setActivo(especialDb.get().getActivo());
		
		return especialDto;
		
	}

}
