package com.groupal.backendexamen.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groupal.backendexamen.dto.CompraComercioDto;
import com.groupal.backendexamen.dto.ProductoDto;
import com.groupal.backendexamen.dto.ShoppingCartDto;
import com.groupal.backendexamen.service.CompraComercioService;
import com.groupal.backendexamen.service.ShoppingCartService;
import com.groupal.backendexamen.service.UsuarioService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/admin")
public class ShoppingCartController {

	@Autowired
	private CompraComercioService compraComercioService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ShoppingCartService shippingCartComercioService;
	
	@PutMapping("/cart/checkout/{usuarioId}")
    public ResponseEntity < ShoppingCartDto > checkout(@RequestBody List<ProductoDto> listaDto, @PathVariable Integer usuarioId ) {
        return ResponseEntity.ok().body(shippingCartComercioService.checkout(listaDto, usuarioId));
    }
	
	@PutMapping("/cart/checkout/guardar")
    public ResponseEntity < ShoppingCartDto > guardarCheckout(@RequestBody ShoppingCartDto shoppingCartDto) {

		//Toda la logica para guardar y finalizar la compra en compraComercio

		CompraComercioDto compraComercioDto = new CompraComercioDto();
		compraComercioDto.setFecha(new Date());
		compraComercioDto.setTotal(shoppingCartDto.getTotalConDescuento());
		compraComercioDto.setActivo(true);
		compraComercioDto.setUsuario(shoppingCartDto.getUsuario());
		
		compraComercioService.save(compraComercioDto);
		
		//verifica si se convirtio en usuario vip
		usuarioService.validarUsuarioVip(shoppingCartDto.getUsuario().getId());
		
        return ResponseEntity.ok().body(shoppingCartDto);
    }
	
}