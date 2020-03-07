package com.gft.apishow.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;



@Entity
public class Vendas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonProperty("quantidade")
	@NotNull(message = "O campo quantidade de vendas é obrigatorio")
	private Integer qtdVendas;
	
	@NotNull(message = "O campo usuario é obrigatorio")
	@ManyToOne
	@JoinColumn(name = "USUARIO_ID")
	private Usuario usuario;
	
	
	@NotNull(message = "O campo evento é obrigatorio")
	@ManyToOne
	@JoinColumn(name = "EVENTO_ID")
	private Evento eventos;
	
	
	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Evento getEventos() {
		return eventos;
	}

	public void setEventos(Evento eventos) {
		this.eventos = eventos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQtdVendas() {
		return qtdVendas;
	}

	public void setQtdVendas(int qtdVendas) {
		this.qtdVendas = qtdVendas;
	}
	
	

}
