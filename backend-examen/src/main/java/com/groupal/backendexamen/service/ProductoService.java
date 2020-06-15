package com.groupal.backendexamen.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupal.backendexamen.dto.ProductoDto;
import com.groupal.backendexamen.model.Producto;
import com.groupal.backendexamen.repository.ProductoRepository;
import com.groupal.backendexamen.utils.ResourceNotFoundException;

@Service
public class ProductoService implements IProductoService{

	@Autowired
	ProductoRepository productoRepository;
	
	@Override
	public List<ProductoDto> findAll() {
	
		List<Producto> listDb = productoRepository.findAll();
		
		if (listDb.isEmpty()) {
			 return null;
	     }
		
		List<ProductoDto> list = new ArrayList<ProductoDto>();
		
		for(Producto producto: listDb) {
			ProductoDto productoDto = new ProductoDto();
			productoDto.setId(producto.getId());
			productoDto.setNombre(producto.getNombre());
			productoDto.setDescripcion(producto.getDescripcion());
			productoDto.setImagen(producto.getImagen());
			productoDto.setPrecio(producto.getPrecio());
			productoDto.setStock(producto.getStock());
			productoDto.setActivo(producto.getActivo());
			list.add(productoDto);
		}
		return list;
		
	}

	@Override
	public ProductoDto findById(Integer productoId) {
		
		Optional<Producto> productoDb = productoRepository.findById(productoId);
	 	
		if (!productoDb.isPresent()) {
			throw new ResourceNotFoundException("Record not found with id : " + productoId);
		}
      
		ProductoDto productoDto = new ProductoDto();
		//setear los datos en el dto
		productoDto.setId(productoDb.get().getId());
		productoDto.setNombre(productoDb.get().getNombre());
		productoDto.setDescripcion(productoDb.get().getDescripcion());
		productoDto.setImagen(productoDb.get().getImagen());
		productoDto.setPrecio(productoDb.get().getPrecio());
		productoDto.setStock(productoDb.get().getStock());
	    productoDto.setActivo(productoDb.get().getActivo());
		
		return productoDto;
		
	}

}
