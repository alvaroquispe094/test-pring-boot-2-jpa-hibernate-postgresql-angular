package com.groupal.backendexamen.dto;

public class ShoppingCartDto {
	
	private Boolean esUsuarioVip;
	
	private Boolean esDescuento4;
	
	private Boolean esDescuentoComun10;
	
	private Boolean esDescuentoEspecial10;
	
	private Boolean esDescuentoVip10;
	
	private UsuarioDto usuario;
	
	private Double descuento25;
	
	private Double descuentoVip;
	
	private Double total;
	
	private Double totalConDescuento;
	

	//Getters y setters
	public Boolean getEsUsuarioVip() {
		return esUsuarioVip;
	}

	public void setEsUsuarioVip(Boolean esUsuarioVip) {
		this.esUsuarioVip = esUsuarioVip;
	}

	public Boolean getEsDescuento4() {
		return esDescuento4;
	}

	public void setEsDescuento4(Boolean esDescuento4) {
		this.esDescuento4 = esDescuento4;
	}

	public Boolean getEsDescuentoComun10() {
		return esDescuentoComun10;
	}

	public void setEsDescuentoComun10(Boolean esDescuentoComun10) {
		this.esDescuentoComun10 = esDescuentoComun10;
	}

	public Boolean getEsDescuentoEspecial10() {
		return esDescuentoEspecial10;
	}

	public void setEsDescuentoEspecial10(Boolean esDescuentoEspecial10) {
		this.esDescuentoEspecial10 = esDescuentoEspecial10;
	}

	public Boolean getEsDescuentoVip10() {
		return esDescuentoVip10;
	}

	public void setEsDescuentoVip10(Boolean esDescuentoVip10) {
		this.esDescuentoVip10 = esDescuentoVip10;
	}

	public UsuarioDto getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDto usuario) {
		this.usuario = usuario;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Double getTotalConDescuento() {
		return totalConDescuento;
	}

	public void setTotalConDescuento(Double totalConDescuento) {
		this.totalConDescuento = totalConDescuento;
	}

	public Double getDescuento25() {
		return descuento25;
	}

	public void setDescuento25(Double descuento25) {
		this.descuento25 = descuento25;
	}

	public Double getDescuentoVip() {
		return descuentoVip;
	}

	public void setDescuentoVip(Double descuentoVip) {
		this.descuentoVip = descuentoVip;
	}
}
