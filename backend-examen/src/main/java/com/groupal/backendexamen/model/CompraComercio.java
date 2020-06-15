package com.groupal.backendexamen.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "compraComercioIdSeq", sequenceName = "compra_comercio_id_seq", allocationSize=1)
@Table(name="compra_comercio")
public class CompraComercio {
	
	@Id  
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "compraComercioIdSeq")
	private Integer id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn( name="usuario_id")
    private Usuario usuario;
	
	private Date fecha;
	private Double total;
	private Boolean activo;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	
}
