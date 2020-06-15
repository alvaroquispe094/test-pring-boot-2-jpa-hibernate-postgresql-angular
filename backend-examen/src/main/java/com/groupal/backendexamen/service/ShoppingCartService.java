package com.groupal.backendexamen.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupal.backendexamen.dto.CompraComercioDto;
import com.groupal.backendexamen.dto.EspecialDto;
import com.groupal.backendexamen.dto.ProductoDto;
import com.groupal.backendexamen.dto.ShoppingCartDto;
import com.groupal.backendexamen.dto.UsuarioDto;

@Service
public class ShoppingCartService implements IShoppingCartService{

	@Autowired
	private ICompraComercioService compraComercioService;
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private IEspecialService especialService;
	
	
	@Override
	public CompraComercioDto save(ShoppingCartDto shoppinCartDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShoppingCartDto findById(Integer shoppinCartDtoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShoppingCartDto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShoppingCartDto checkout(List<ProductoDto> checkoutList, Integer usuarioId) {
		
		Double total = 0.0;
		
		ShoppingCartDto shoppingCartDto = new ShoppingCartDto();
		
		//Obtengo la lista de compras realizadas del usuario
		List<CompraComercioDto> compraComercioList = compraComercioService.findByUsuarioId(usuarioId);
		
		//obtengo del usuario
		UsuarioDto usuarioDto = usuarioService.findById(usuarioId);
		shoppingCartDto.setUsuario(usuarioDto);
		
		// Cantidad de items que hay y el total a pagar sin descuentos
		Integer cant_items = 0;
		for(ProductoDto productoDto: checkoutList) {
			cant_items += productoDto.getCantidad();
			total += (productoDto.getPrecio() * productoDto.getCantidad());
		}
		shoppingCartDto.setTotal(total);
		shoppingCartDto.setTotalConDescuento(total);
		
		//validacion para saber si tiene 4 items en el carrito
		if(cant_items == 4) {
			shoppingCartDto.setEsDescuento4(true);
			shoppingCartDto.setDescuento25(shoppingCartDto.getTotal() * 0.25);
			shoppingCartDto.setTotalConDescuento(shoppingCartDto.getTotalConDescuento() - (shoppingCartDto.getTotal() * 0.25));
		}
		
		//validacion para saber si tiene 10 items en el carrito
		if(cant_items >= 10) {
			shoppingCartDto.setEsDescuento4(true);
			
			if(!this.esFechaEspecial(new Date()) && !this.esUsuarioVip(usuarioId)) {
				shoppingCartDto.setEsDescuentoComun10(true);
				shoppingCartDto.setTotalConDescuento(shoppingCartDto.getTotalConDescuento() - 100);
			}
			
			if(this.esFechaEspecial(new Date())) {
				shoppingCartDto.setEsDescuentoEspecial10(true);
				shoppingCartDto.setTotalConDescuento(shoppingCartDto.getTotalConDescuento() - 300);
			}
			
			if(this.esUsuarioVip(usuarioId)) {
				shoppingCartDto.setEsDescuentoVip10(true);
				ProductoDto producto = this.getProductoMasBarato(checkoutList);
				
				shoppingCartDto.setDescuentoVip((shoppingCartDto.getTotalConDescuento() - producto.getPrecio()) - 500);
				shoppingCartDto.setTotalConDescuento(shoppingCartDto.getTotalConDescuento() - producto.getPrecio());
				shoppingCartDto.setTotalConDescuento(shoppingCartDto.getTotalConDescuento() - 500);
			}
			
		}
		
		//toda la logica para valiar fecha especial, descuentos, usuario vip, etc
		
		return shoppingCartDto;
	}
	
	public ProductoDto getProductoMasBarato(List<ProductoDto> checkoutList) {
		
		ProductoDto productoMasBarato = checkoutList.get(0);
		
		for(ProductoDto productoDto : checkoutList) {
			if(productoDto.getPrecio() < productoMasBarato.getPrecio()) {
				productoMasBarato = productoDto;
			}
		}

		return productoMasBarato;
	}
	
	public Boolean esFechaEspecial(Date fechaHoy) {
		
		Boolean esEspecial = false;
		
		//obtengo dias especiales
		List<EspecialDto> especialList = especialService.findAll();
		
		// logica para comparar la fecha de hoy con las fechas especiales de la bd	
		
		for(EspecialDto especialDto : especialList) {
			if (fechaHoy.getYear() == especialDto.getFecha().getYear() &&
					fechaHoy.getMonth() == especialDto.getFecha().getMonth() &&
							fechaHoy.getDate() == especialDto.getFecha().getDate()) {
		      return true ;
		    } 
		 
		}
		
		return false;
	}
	
	public Boolean esUsuarioVip(Integer usuarioId) {

		//obtengo del usuario
		UsuarioDto usuarioDto = usuarioService.findById(usuarioId);
		
		if(usuarioDto.getVip()) {
			return true;
			
		}else {
			return false;
		}
	}

}
