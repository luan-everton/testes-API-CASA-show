package com.gft.apishow.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonProperty("nome")
	@NotEmpty(message = "O campo nome não pode ser vazio")
	private String userName;
	
	@OneToMany(mappedBy = "usuario" ,cascade = CascadeType.ALL)
	@JsonIgnore
    private List<Vendas> vendas;
    
    
	public List<Vendas> getVendas() {
		return vendas;
	}
	public void setVendas(List<Vendas> vendas) {
		this.vendas = vendas;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	


}
