package com.groupal.backendexamen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groupal.backendexamen.dto.EspecialDto;
import com.groupal.backendexamen.service.EspecialService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/admin")
public class EspecialController {
	
	@Autowired
	private EspecialService especialService;
	
	@GetMapping("/especiales")
    public ResponseEntity < List<EspecialDto> > getAllEspeciales() {
        return ResponseEntity.ok().body(especialService.findAll());
    }
    
    @GetMapping("/especial/{id}")
    public ResponseEntity < EspecialDto > getEspecialById(@PathVariable Integer id) {
    	return ResponseEntity.ok().body(especialService.findById(id));
    }
}
