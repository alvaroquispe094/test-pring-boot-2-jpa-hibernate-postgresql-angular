package com.groupal.backendexamen.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupal.backendexamen.dto.CompraComercioDto;
import com.groupal.backendexamen.dto.EspecialDto;
import com.groupal.backendexamen.dto.UsuarioDto;
import com.groupal.backendexamen.model.CompraComercio;
import com.groupal.backendexamen.model.Usuario;
import com.groupal.backendexamen.repository.UsuarioRepository;
import com.groupal.backendexamen.utils.ResourceNotFoundException;

@Service
public class UsuarioService implements IUsuarioService{

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	IEspecialService especialService;
	
	@Autowired
	CompraComercioService compraComercioService;
	
	@Override
	public List<UsuarioDto> findAll() {
	
		List<Usuario> listDb = usuarioRepository.findAll();
		
		if (listDb.isEmpty()) {
			 return null;
	     }
		
		List<UsuarioDto> list = new ArrayList<UsuarioDto>();
		
		for(Usuario usuario: listDb) {
			UsuarioDto usuarioDto = new UsuarioDto();
			usuarioDto.setId(usuario.getId());
			usuarioDto.setNombre(usuario.getNombre());
			usuarioDto.setApellido(usuario.getApellido());
			usuarioDto.setUsername(usuario.getUsername());
			usuarioDto.setPassword(usuario.getPassword());
			usuarioDto.setMail(usuario.getMail());
			usuarioDto.setDireccion(usuario.getDireccion());
			usuarioDto.setDocumento(usuario.getDocumento());
			usuarioDto.setVip(usuarioDto.getVip());
			usuarioDto.setActivo(usuario.getActivo());
			list.add(usuarioDto);
		}
		return list;
		
	}

	@Override
	public UsuarioDto findById(Integer usuarioId) {
		
		Optional<Usuario> usuarioDb = usuarioRepository.findById(usuarioId);
	 	
		if (!usuarioDb.isPresent()) {
			throw new ResourceNotFoundException("Record not found with id : " + usuarioId);
		}
      
		UsuarioDto usuarioDto = new UsuarioDto();
		usuarioDto.setId(usuarioDb.get().getId());
		usuarioDto.setNombre(usuarioDb.get().getNombre());
		usuarioDto.setApellido(usuarioDb.get().getApellido());
		usuarioDto.setUsername(usuarioDb.get().getUsername());
		usuarioDto.setPassword(usuarioDb.get().getPassword());
		usuarioDto.setMail(usuarioDb.get().getMail());
		usuarioDto.setDireccion(usuarioDb.get().getDireccion());
		usuarioDto.setVip(usuarioDb.get().getVip());
		usuarioDto.setDocumento(usuarioDb.get().getDocumento());
		usuarioDto.setActivo(usuarioDb.get().getActivo());
		
		return usuarioDto;
		
	}

	@Override
	public Boolean validarUsuarioVip(Integer usuarioId) {
		
		//valida si es vip o no
		Boolean esVip = this.esUsuarioVip(usuarioId);
		
		return esVip;
	}
	
    public Boolean esUsuarioVip(Integer usuarioId) {
		
		Boolean esVip = false;
		Double acum  = 0.0;
		Date fechaVip = new Date();
		List<CompraComercioDto> listDb = compraComercioService.findByUsuarioId(usuarioId);
		
		// logica para comparar la fecha de hoy con las fechas especiales de la bd	
		
		Integer month_actual = listDb.get(0).getFecha().getMonth();
		for(CompraComercioDto compraComercioDto : listDb) {
			if(compraComercioDto.getUsuario().getFechaVip() == null) {
				
			
			
				if(compraComercioDto.getFecha().getMonth() != month_actual) {
					acum = 0.0;
					if(acum >= 10000) {
						compraComercioDto.getUsuario().setVip(true);
						compraComercioDto.getUsuario().setFechaVip(new Date());
						this.save(compraComercioDto.getUsuario());
						return true;
					}
					
					month_actual = compraComercioDto.getFecha().getMonth();
					acum += compraComercioDto.getTotal();
				}else {
					acum += compraComercioDto.getTotal();
				}
			}else {
				if(compraComercioDto.getFecha().getMonth() != month_actual) {
					acum = 0.0;
					if(acum >= 10000 && (compraComercioDto.getFecha().getMonth()>compraComercioDto.getUsuario().getFechaVip().getMonth())) {
						compraComercioDto.getUsuario().setVip(true);
						compraComercioDto.getUsuario().setFechaVip(new Date());
						this.save(compraComercioDto.getUsuario());
						return true;
					}
					
					month_actual = compraComercioDto.getFecha().getMonth();
					acum += compraComercioDto.getTotal();
				}else {
					acum += compraComercioDto.getTotal();
				}
			}
		}
		
		//para tomar en cuenta el ultimo de la lista, sino el for lo omite
		if(acum >= 10000) {
			listDb.get(listDb.size() - 1).getUsuario().setVip(true);
			listDb.get(listDb.size() - 1).getUsuario().setFechaVip(new Date());
			this.save(listDb.get(listDb.size() - 1).getUsuario());
			return true;
		}
		
		return esVip;
	}

	@Override
	public List<UsuarioDto> findAllVip() {
		List<Usuario> listDb = usuarioRepository.findAll();
		
		if (listDb.isEmpty()) {
			 return null;
	     }
		
		List<UsuarioDto> list = new ArrayList<UsuarioDto>();
		
		for(Usuario usuario: listDb) {
			if(usuario.getVip()) {
				
				UsuarioDto usuarioDto = new UsuarioDto();
				usuarioDto.setId(usuario.getId());
				usuarioDto.setNombre(usuario.getNombre());
				usuarioDto.setApellido(usuario.getApellido());
				usuarioDto.setUsername(usuario.getUsername());
				usuarioDto.setPassword(usuario.getPassword());
				usuarioDto.setMail(usuario.getMail());
				usuarioDto.setDireccion(usuario.getDireccion());
				usuarioDto.setDocumento(usuario.getDocumento());
				usuarioDto.setVip(usuario.getVip());
				usuarioDto.setFechaVip(usuario.getFechaVip() != null ? usuario.getFechaVip() : null);
				usuarioDto.setActivo(usuario.getActivo());
				list.add(usuarioDto);
			}
		}
		return list;
	}

	@Override
	public UsuarioDto save(UsuarioDto usuarioDto) {

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
		usuario.setFechaVip(usuarioDto.getFechaVip() != null?usuarioDto.getFechaVip() : null);
		usuario.setActivo(usuarioDto.getActivo());
		
		
		usuarioRepository.save(usuario);		
		
		return usuarioDto;
	}

}
