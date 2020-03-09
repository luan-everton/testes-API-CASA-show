package com.gft.apishow.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gft.apishow.ServiceExceptions.UsuarioExistente;
import com.gft.apishow.ServiceExceptions.UsuarioNaoEncontrado;
import com.gft.apishow.domain.Usuario;
import com.gft.apishow.repository.UsuarioRepository;

@Service
public class UsuarioServices {

	@Autowired
	private UsuarioRepository usuarioRepository;
	public List<Usuario>listar(){
		
		return usuarioRepository.findAll();
		
	}
	public Usuario salvar(Usuario usuario) {
		 
		Usuario nomeusuario = usuarioRepository.findByUserName(usuario.getUserName());
		if(nomeusuario!= null) {
			throw new UsuarioExistente("usuario já existente");
		}
		
		if (usuario.getId() != null) {
			Optional<Usuario> a = usuarioRepository.findById(usuario.getId());
			
			if (a.isPresent()) {
				throw new UsuarioExistente(" usuario já existente");
			
			}
			
		}
		return usuarioRepository.save(usuario);
	}
	
	public Optional<Usuario> buscar (Long id) {
	Optional<Usuario>usuario = usuarioRepository.findById(id);
	
		if(usuario.isPresent()) {
		} else {
			throw new UsuarioNaoEncontrado ("Usuario não encontrado");
		}
		return usuario;
	}
	public void deletar (Long id) {
		
		try {
			usuarioRepository.deleteById(id);

		} catch ( EmptyResultDataAccessException e) {
			throw new UsuarioNaoEncontrado("Usuario não encontrado.");
		}
		
	}
	public void atualizar(Usuario usuario) {
		verificarExistencia(usuario);
		usuarioRepository.save(usuario);
		
	}
	private void verificarExistencia (Usuario usuario) {
		buscar(usuario.getId());
		
	}

	
	

	

}





