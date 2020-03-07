package com.gft.apishow.Resources;

import java.net.URI;
import java.sql.Date;
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

import com.gft.apishow.Services.EventoServices;
import com.gft.apishow.domain.Evento;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@Api(tags="Eventos")
@RestController
@RequestMapping("/eventos")
public class EventoResources{

	@Autowired
	private EventoServices eventoService ;
	
	@RequestMapping(method = RequestMethod.GET)
	
	
	@ApiOperation("Listar eventos")
	public ResponseEntity<List<Evento>> listar(){
		List<Evento> eventos = eventoService.listar();
		return ResponseEntity.status(HttpStatus.OK).body(eventos);
	}
	
	@ApiOperation("Savlar evento")
	@RequestMapping(method = RequestMethod.POST )
	public ResponseEntity<Void> salvar(@ApiParam(value ="Salvar evento ",example ="1")@Valid @RequestBody Evento evento){
	evento = eventoService.salvar(evento)	;
	URI uri= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(evento.getId()).toUri();
	
	return ResponseEntity.created(uri).build(); 
	
	
	}
	
	@ApiOperation("Buscar um evento por ID")
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Evento>> buscar(@ApiParam(value ="Buscar evento por ID",example =" 1")@PathVariable Long id){
		Optional<Evento> eventos = eventoService.buscar(id);
		return ResponseEntity.status(HttpStatus.OK).body(eventos);
	}

	@ApiOperation("Excluir evento")
    @DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id){
		eventoService.deletar(id);
		
		 return ResponseEntity.noContent().build();
		
	}
	  

	@ApiOperation("Atualizar um evento")
	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar (@ApiParam(value ="Atualizar evento por ID",example ="1")@RequestBody Evento evento,  @PathVariable("id")  Long id) {

		evento.setId(id);
		eventoService.atualizar(evento);
		
		return ResponseEntity.noContent().build();
		
  }
	@ApiOperation("Listar eventos  por capacidade em  ordem crescente")
	@GetMapping("/listar/Capacidade/Asc")
	public ResponseEntity<List<Evento>>listaEventocrescente(Integer lotacao){
		return ResponseEntity.status(HttpStatus.OK).body(eventoService.listarEventocrescente(lotacao));
	}
	
	@ApiOperation("Listar eventos  por capacidade em  ordem decrescente")
	@GetMapping("/listar/Capacidade/Desc")
	public ResponseEntity<List<Evento>>listaEventodecrecente(Integer capacidade){
		return ResponseEntity.status(HttpStatus.OK).body(eventoService.listarEventoDecrecente(capacidade));
	}
	
	@ApiOperation("Listar eventos  por data  em  ordem crescente")
	@GetMapping("/listar/data/Asc")
	public ResponseEntity<List<Evento>>listaDataEventocrescente(Date dataEvento){
		return ResponseEntity.status(HttpStatus.OK).body(eventoService.listarDatacrescente(dataEvento));
	}
	
	@ApiOperation("Listar eventos  por data  em  ordem decrescente")
	@GetMapping("/listar/data/Desc")
	public ResponseEntity<List<Evento>>listaDataEventodecrescente(Date dataEvento){
		return ResponseEntity.status(HttpStatus.OK).body(eventoService.listarDataDecrescente(dataEvento));
	}
	@ApiOperation("Listar eventos  por valor  em  ordem crescente")
	@GetMapping("/listar/Preco/Asc")
	public ResponseEntity<List<Evento>>listaValorcrescente(Integer valorIngresso){
		return ResponseEntity.status(HttpStatus.OK).body(eventoService.listarValorcrescente(valorIngresso));
	}

	@ApiOperation("Listar eventos  por valor  em  ordem decrescente")
	@GetMapping("/listar/Preco/Desc")
	public ResponseEntity<List<Evento>>listaValorDecrescente(Integer valor){
		return ResponseEntity.status(HttpStatus.OK).body(eventoService.listarValorDecrescente(valor));
	}
	@ApiOperation("Listar eventos  por nome  em  ordem crescente")
	@GetMapping("/listar/Nome/Asc")
	public ResponseEntity<List<Evento>>listaNomeEventocrescente(String nomeEvento){
		return ResponseEntity.status(HttpStatus.OK).body(eventoService.listarNomeEventocrescente(nomeEvento));
	}

	@ApiOperation("Listar eventos  por nome  em  ordem decrescente")
	@GetMapping("/listar/Nome/Desc")
	public ResponseEntity<List<Evento>>listaNomeEventoDecrescente(String nomeEvento){
		return ResponseEntity.status(HttpStatus.OK).body(eventoService.listarNomeEventoDecrescente(nomeEvento));
	}

	
	
}
	
	

