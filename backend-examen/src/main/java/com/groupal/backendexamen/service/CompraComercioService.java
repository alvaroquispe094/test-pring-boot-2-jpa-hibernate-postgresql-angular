package com.groupal.backendexamen.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupal.backendexamen.dto.CompraComercioDto;
import com.groupal.backendexamen.dto.UsuarioDto;
import com.groupal.backendexamen.model.CompraComercio;
import com.groupal.backendexamen.model.Usuario;
import com.groupal.backendexamen.repository.CompraComercioRepository;
import com.groupal.backendexamen.utils.ResourceNotFoundException;

@Service
public class CompraComercioService implements ICompraComercioService{

	@Autowired
	private CompraComercioRepository compraComercioRepository;
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Override
	public CompraComercioDto save(CompraComercioDto compraComercioDto) {
		
		UsuarioDto usuarioDto = usuarioService.findById(compraComercioDto.getUsuario().getId());
		
		Usuario usuario = new Usuario();
		usuario.setId(usuarioDto.getId());
		usuario.setNombre(usuarioDto.getNombre());
		usuario.setApellido(usuarioDto.getApellido());
		usuario.setUsername(usuarioDto.getUsername());
		usuario.setPassword(usuarioDto.getPassword());
		usuario.setMail(usuarioDto.getMail());
		usuario.setDireccion(usuarioDto.getDireccion());
		usuario.setDocumento(usuarioDto.getDocumento());
		usuario.setVip(usuarioDto.getVip());
		usuario.setActivo(usuarioDto.getActivo());
		
		CompraComercio compraComercio = new CompraComercio();
		compraComercio.setUsuario(usuario);
		compraComercio.setFecha(compraComercioDto.getFecha());
		compraComercio.setTotal(compraComercioDto.getTotal());
		compraComercio.setActivo(compraComercioDto.getActivo());
		
		compraComercioRepository.save(compraComercio);		
		
		return compraComercioDto;
	}

	@Override
	public List<CompraComercioDto> findAll() {
		
		List<CompraComercio> listDb = compraComercioRepository.findAll();
		
		if (listDb.isEmpty()) {
			 return null;
	     }
		List<CompraComercioDto> list = new ArrayList<CompraComercioDto>();
		
		for(CompraComercio compraComercio: listDb) {
			UsuarioDto usuarioDto = new UsuarioDto();
			usuarioDto.setId(compraComercio.getUsuario().getId());
			usuarioDto.setNombre(compraComercio.getUsuario().getNombre());
			usuarioDto.setApellido(compraComercio.getUsuario().getApellido());
			usuarioDto.setUsername(compraComercio.getUsuario().getUsername());
			usuarioDto.setPassword(compraComercio.getUsuario().getPassword());
			usuarioDto.setMail(compraComercio.getUsuario().getMail());
			usuarioDto.setDireccion(compraComercio.getUsuario().getDireccion());
			usuarioDto.setDocumento(compraComercio.getUsuario().getDocumento());
			usuarioDto.setActivo(compraComercio.getUsuario().getActivo());
			
			CompraComercioDto compraComercioDto = new CompraComercioDto();
			compraComercioDto.setId(compraComercio.getId());
			compraComercioDto.setUsuario(usuarioDto);
			compraComercioDto.setFecha(compraComercio.getFecha());
			compraComercioDto.setTotal(compraComercio.getTotal());
			compraComercioDto.setActivo(compraComercio.getActivo());

			list.add(compraComercioDto);
		}
		return list;
	}

	@Override
	public CompraComercioDto findById(Integer compraComercioId) {
		
		 Optional<CompraComercio> compraComercioDb = compraComercioRepository.findById(compraComercioId);
		 
		 if (!compraComercioDb.isPresent()) {
			 throw new ResourceNotFoundException("Record not found with id : " + compraComercioId);
	     }
		 
		 UsuarioDto usuarioDto = new UsuarioDto();
		 usuarioDto.setId(compraComercioDb.get().getUsuario().getId());
		 usuarioDto.setNombre(compraComercioDb.get().getUsuario().getNombre());
		 usuarioDto.setApellido(compraComercioDb.get().getUsuario().getApellido());
		 usuarioDto.setUsername(compraComercioDb.get().getUsuario().getUsername());
		 usuarioDto.setPassword(compraComercioDb.get().getUsuario().getPassword());
		 usuarioDto.setMail(compraComercioDb.get().getUsuario().getMail());
		 usuarioDto.setDireccion(compraComercioDb.get().getUsuario().getDireccion());
		 usuarioDto.setDocumento(compraComercioDb.get().getUsuario().getDocumento());
		 usuarioDto.setActivo(compraComercioDb.get().getUsuario().getActivo());
	      
		 CompraComercioDto compraComercioDto = new CompraComercioDto();
		 //setear los datos en el dto
		 compraComercioDto.setId(compraComercioDb.get().getId());
		 compraComercioDto.setUsuario(usuarioDto);
		 compraComercioDto.setFecha(compraComercioDb.get().getFecha());
		 compraComercioDto.setTotal(compraComercioDb.get().getTotal());
		 compraComercioDto.setActivo(compraComercioDb.get().getActivo());
		 
		return compraComercioDto;
	}

	@Override
	public List<CompraComercioDto> findByUsuarioId(Integer usuarioId) {
        
		List<CompraComercio> listDb = compraComercioRepository.findByUsuarioId(usuarioId);
		
		if (listDb.isEmpty()) {
			 return null;
	     }
		List<CompraComercioDto> list = new ArrayList<CompraComercioDto>();
		
		for(CompraComercio compraComercio: listDb) {
			UsuarioDto usuarioDto = new UsuarioDto();
			usuarioDto.setId(compraComercio.getUsuario().getId());
			usuarioDto.setNombre(compraComercio.getUsuario().getNombre());
			usuarioDto.setApellido(compraComercio.getUsuario().getApellido());
			usuarioDto.setUsername(compraComercio.getUsuario().getUsername());
			usuarioDto.setPassword(compraComercio.getUsuario().getPassword());
			usuarioDto.setMail(compraComercio.getUsuario().getMail());
			usuarioDto.setDireccion(compraComercio.getUsuario().getDireccion());
			usuarioDto.setDocumento(compraComercio.getUsuario().getDocumento());
			usuarioDto.setVip(compraComercio.getUsuario().getVip());
			usuarioDto.setFechaVip(compraComercio.getUsuario().getFechaVip()!=null ? compraComercio.getUsuario().getFechaVip() : null);
			usuarioDto.setActivo(compraComercio.getUsuario().getActivo());
			
			CompraComercioDto compraComercioDto = new CompraComercioDto();
			compraComercioDto.setId(compraComercio.getId());
			compraComercioDto.setUsuario(usuarioDto);
			compraComercioDto.setFecha(compraComercio.getFecha());
			compraComercioDto.setTotal(compraComercio.getTotal());
			compraComercioDto.setActivo(compraComercio.getActivo());

			list.add(compraComercioDto);
		}
		return list;
	}

}
