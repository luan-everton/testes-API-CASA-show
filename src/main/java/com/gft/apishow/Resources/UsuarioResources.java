package com.gft.apishow.Resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gft.apishow.Services.UsuarioServices;
import com.gft.apishow.domain.Usuario;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags ="Usuario")
@RestController
@RequestMapping("/usuarios")
public class UsuarioResources {



	@Autowired
	private UsuarioServices usuarioService ;
	
	@ApiOperation("Listar todos Usuarios")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> listar(){
		List<Usuario> usuarios = usuarioService.listar();
		return ResponseEntity.status(HttpStatus.OK).body(usuarios);
	}
	
	@ApiOperation("Salvar usuario")
	@RequestMapping(method = RequestMethod.POST )
	public ResponseEntity<Void> salvar(@ApiParam(value ="Salvar usuario ",example ="1")@Valid @RequestBody Usuario usuario){
	usuario = usuarioService.salvar(usuario)	;
	URI uri= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId()).toUri();
	
	return ResponseEntity.created(uri).build(); 
	
	
	}
	@ApiOperation("Buscar um usuario por ID")
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Usuario>> buscar(@ApiParam(value ="Buscar usuario por ID",example ="1")@PathVariable Long id){
		Optional<Usuario> usuarios = usuarioService.buscar(id);
		return ResponseEntity.status(HttpStatus.OK).body(usuarios);
	}

	@ApiOperation("Excluir usuario")
    @DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id){
    	usuarioService.deletar(id);
		
		 return ResponseEntity.noContent().build();
		
	}
	  

	@ApiOperation("Atualizar um usuario por ID")
	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar (@ApiParam(value ="Atualizar usuario por ID",example ="1")@RequestBody Usuario usuario,  @PathVariable("id")  Long id) {

		usuario.setId(id);
		usuarioService.atualizar(usuario);
		
		return ResponseEntity.noContent().build();
		
  }

	
}

