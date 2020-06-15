package com.groupal.backendexamen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groupal.backendexamen.dto.UsuarioDto;
import com.groupal.backendexamen.service.UsuarioService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/admin")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/usuarios")
    public ResponseEntity < List<UsuarioDto> > getAllUsuarios() {
        return ResponseEntity.ok().body(usuarioService.findAll());
    }
    
    @GetMapping("/usuario/{id}")
    public ResponseEntity < UsuarioDto > getUsuarioById(@PathVariable Integer id) {
    	return ResponseEntity.ok().body(usuarioService.findById(id));
    }
    
    @GetMapping("/usuarios/vip")
    public ResponseEntity < List<UsuarioDto> > getAllIsuariosVip() {
    	return ResponseEntity.ok().body(usuarioService.findAllVip());
    }
    
}
