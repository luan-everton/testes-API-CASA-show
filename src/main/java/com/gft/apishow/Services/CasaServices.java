package com.gft.apishow.Services;

import org.springframework.stereotype.Service;

import com.gft.apishow.ServiceExceptions.CasaExistenteException;
import com.gft.apishow.ServiceExceptions.CasaShowNaoEncontradaException;
import com.gft.apishow.domain.Casa;
import com.gft.apishow.repository.CasaRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;




@Service
public class CasaServices {

	
		@Autowired
		private CasaRepository casaRepository;
		
		public List<Casa>listar(){
			
			return casaRepository.findAll();
			
		}
		public Casa salvar(Casa casa) {
			 
			Casa casaNome = casaRepository.findByNomeCasa(casa.getNomeCasa());
			if(casaNome != null) {
				throw new CasaExistenteException(" casa já existente");
			}
			
			if (casa.getId() != null) {
				Optional<Casa> a = casaRepository.findById(casa.getId());
				
				if (a.isPresent()) {
					throw new CasaExistenteException(" casa já existente");
				}
				
				
			}
			return casaRepository.save(casa);
		}
		
		
		
		
		
		public Optional<Casa> buscar (Long id) {
			
		Optional<Casa>casa = casaRepository.findById(id);
		
			if(casa.isPresent()) {
				
			}else {
				
				throw new CasaShowNaoEncontradaException("a casa de show não foi encontrada.");

			}
			return casa;
		}
		public void deletar (Long id) {
			
			try {
				casaRepository.deleteById(id);

			} catch ( EmptyResultDataAccessException e) {
				throw new CasaShowNaoEncontradaException("A casa de show não pode ser encontrada.");
			}
			
		}
		public void atualizar(Casa casa) {
			verificarExistencia(casa);
			casaRepository.save(casa);
			
		}
		private void verificarExistencia (Casa casa) {
			buscar(casa.getId());
			
		}
		public List<Casa> listarCrescente(){
			return casaRepository.findAll(Sort.by(Sort.Direction.ASC,"nomeCasa"));
		}

		public List<Casa> listarDecrecente(){
			return casaRepository.findAll(Sort.by(Sort.Direction.DESC,"nomeCasa"));
		}
		
		public Casa buscarPorNome(String nomeCasa) {
			
			Casa casa = casaRepository.findByNomeCasa(nomeCasa);
			if(casa==null) {
				throw new CasaShowNaoEncontradaException("a casa de show não foi encontrada.");
			}
			return casa;
		
		}

	}



