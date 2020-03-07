package com.gft.apishow.domain;



import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;



@Entity
public class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@NotEmpty(message = "O nome do evento é obrigatorio")
	private String nomeEvento;
	
	@ManyToOne
	private Casa casa;

	@NotEmpty(message = "O genero é obrigatorio")
	 private String genero;
	
	@JsonProperty("capacidade")
	@NotNull(message = "O campo capacidade é obrigatorio")
	 private Integer lotacao;
	
	@NotNull(message ="Data do evento é obrigatorio")
	@JsonFormat(pattern = "dd/MM/yyyy")
	 private Date dataEvento;
	 
	
	@JsonInclude(Include.NON_NULL)
	 private double valorIngresso;
	 
	 @OneToMany(mappedBy = "eventos" , cascade = CascadeType.ALL)
	 @JsonIgnore
	 private List<Vendas> vendas;
	 
	 
	
		

	public String getNomeEvento() {
		return nomeEvento;
	}

	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}

	public List<Vendas> getVendas() {
		return vendas;
	}

	public void setVendas(List<Vendas> vendas) {
		this.vendas = vendas;
	}

	public Casa getCasa() {
		return casa;
	}

	public void setCasa(Casa casa) {
		this.casa = casa;
	}

	public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}


	public double getValorIngresso() {
			return valorIngresso;
		}

		public void setValorIngresso(double valorIngresso) {
			this.valorIngresso = valorIngresso;
		}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Integer getLotacao() {
		return lotacao;
	}

	public void setLotacao(Integer lotacao) {
		this.lotacao = lotacao;
	}

	public Date getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(Date  dataEvento) {
		this.dataEvento = dataEvento;
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
		Evento other = (Evento) obj;
		if (id == null) {
			if (other.id!= null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	 
	
}

