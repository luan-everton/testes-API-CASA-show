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

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Casa {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ApiModelProperty(example="nome da casa de show")
	@NotEmpty(message = "Nome da casa de show é obrigatorio")
	private String nomeCasa;
	
	@ApiModelProperty(example="local da casa de show")
    @NotEmpty(message = "local é obrigatorio")
	private String local;

	@OneToMany(mappedBy = "casa", cascade = CascadeType.ALL)
	@JsonIgnore
    private List<Evento> evento;
	
	
	public Casa(@NotEmpty(message = "O campo nome não pode ser vazio.") String nome,
			@NotEmpty(message = "O campo endereço não pode ser vazio.") String endereco) {
		super();
		this.nomeCasa = nome;
		this.local = endereco;
	}
	
	public Casa() {}

	
  
	public List<Evento> getEvento() {
		
		return evento;
	}

	public void setEvento(List<Evento> evento) {
		this.evento = evento;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCasa() {
		return nomeCasa;
	}

	public void setNomeCasa(String nomeCasa) {
		this.nomeCasa = nomeCasa;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Casa other = (Casa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



	
	

	
	
}