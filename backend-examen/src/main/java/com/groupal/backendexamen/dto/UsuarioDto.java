package com.groupal.backendexamen.dto;

import java.util.Date;

public class UsuarioDto {
	
	private Integer id;
    private String nombre;
    private String apellido;
    private String username;
    private String password;
    private Integer documento;
    private String direccion;
    private String mail;
    private Boolean vip;
	private Boolean activo;
	private Date fechaVip;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getDocumento() {
		return documento;
	}
	public void setDocumento(Integer documento) {
		this.documento = documento;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	public Boolean getVip() {
		return vip;
	}
	public void setVip(Boolean vip) {
		this.vip = vip;
	}
	public Date getFechaVip() {
		return fechaVip;
	}
	public void setFechaVip(Date fechaVip) {
		this.fechaVip = fechaVip;
	}
}
