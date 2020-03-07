package com.gft.apishow.Services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.gft.apishow.ServiceExceptions.EventoExistente;
import com.gft.apishow.ServiceExceptions.EventoNaoEncontrado;
import com.gft.apishow.domain.Evento;
import com.gft.apishow.repository.EventoRepository;
@Service	
public class EventoServices {

	@Autowired
	private EventoRepository eventoRepository;
	public List<Evento>listar(){
		
		return eventoRepository.findAll();
		
	}
	public Evento salvar(Evento evento) {
		evento.setId(null);
		return eventoRepository.save(evento);
	}
	
	public Optional<Evento> buscar (Long id) {
	Optional<Evento>evento = eventoRepository.findById(id);
	
		if(evento.isPresent()) {
			
		}else {
			
			throw new EventoNaoEncontrado("Evento não encontrado.");

		}
		return evento;
	}
	public void deletar (Long id) {
		
		try {
			eventoRepository.deleteById(id);

		} catch ( EmptyResultDataAccessException e) {
			throw new EventoExistente("Evento ja cadastrado.");
		}
		
	}
	public void atualizar(Evento evento) {
		verificarExistencia(evento);
		eventoRepository.save(evento);
		
	}
	private void verificarExistencia (Evento evento) {
		buscar(evento.getId());
		
	}
	
	
	
	public List<Evento> listarEventocrescente(Integer lotacao){
		return eventoRepository.findAll(Sort.by(Sort.Direction.ASC,"lotacao"));
	}

	public List<Evento> listarEventoDecrecente(Integer lotacao){
		return eventoRepository.findAll(Sort.by(Sort.Direction.DESC,"lotacao"));
	}
	
	public List<Evento> listarDatacrescente(Date dataEvento){
		return eventoRepository.findAll(Sort.by(Sort.Direction.ASC,"dataEvento"));
	}
	
	public List<Evento> listarDataDecrescente(Date dataEvento){
		return eventoRepository.findAll(Sort.by(Sort.Direction.DESC,"dataEvento"));
	}
	
	public List<Evento> listarValorcrescente(Integer valorIngresso){
		return eventoRepository.findAll(Sort.by(Sort.Direction.ASC,"valorIngresso"));
	}
	
	public List<Evento> listarValorDecrescente(Integer valorIngresso){
		return eventoRepository.findAll(Sort.by(Sort.Direction.DESC,"valorIngresso"));
	}
	
	public List<Evento> listarNomeEventocrescente(String nomeEvento){
		return eventoRepository.findAll(Sort.by(Sort.Direction.ASC,"nomeEvento"));
	}

	public List<Evento> listarNomeEventoDecrescente(String nomeEvento){
		return eventoRepository.findAll(Sort.by(Sort.Direction.DESC,"nomeEvento"));
	}


	

}


