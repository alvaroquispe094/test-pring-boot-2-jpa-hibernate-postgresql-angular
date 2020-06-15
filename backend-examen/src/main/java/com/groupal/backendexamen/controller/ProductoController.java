package com.groupal.backendexamen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groupal.backendexamen.dto.ProductoDto;
import com.groupal.backendexamen.service.ProductoService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/admin")
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/productos")
    public ResponseEntity < List<ProductoDto> > getAllProductos() {
        return ResponseEntity.ok().body(productoService.findAll());
    }
    
    @GetMapping("/producto/{id}")
    public ResponseEntity < ProductoDto > getProductById(@PathVariable Integer id) {
    	return ResponseEntity.ok().body(productoService.findById(id));
    }
}
