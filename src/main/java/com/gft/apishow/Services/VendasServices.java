package com.gft.apishow.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gft.apishow.ServiceExceptions.NenhumaVendaEncontrada;
import com.gft.apishow.domain.Vendas;
import com.gft.apishow.repository.VendasRepository;

@Service
public class VendasServices {

	@Autowired
	private VendasRepository vendasRepository;
	public List<Vendas>listar(){
		
		return vendasRepository.findAll();
		
	}
	public Vendas salvar(Vendas vendas) {
		vendas.setId(null);
	
		return vendasRepository.save(vendas);
	}
	
	public Optional<Vendas> buscar (Long id) {
	Optional<Vendas>vendas = vendasRepository.findById(id);
		if(vendas.isPresent()) {
		} else {
			throw new NenhumaVendaEncontrada("Nenhuma Venda foi Encontrada");
		}
		return vendas;
	}
	public void deletar (Long id) {
		
		try {
			vendasRepository.deleteById(id);

		} catch ( EmptyResultDataAccessException e) {
			throw new NenhumaVendaEncontrada("Nenhuma Venda foi Encontrada.");
		}
		
	}
	public void atualizar(Vendas vendas) {
		verificarExistencia(vendas);
		vendasRepository.save(vendas);
		
	}
	private void verificarExistencia (Vendas vendas) {
		buscar(vendas.getId());
		
	}

	
	
	
}
