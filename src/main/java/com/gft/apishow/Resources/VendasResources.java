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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gft.apishow.Services.VendasServices;
import com.gft.apishow.domain.Vendas;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Vendas")
@RestController
@RequestMapping("/vendas")
public class VendasResources {



	@Autowired
	private VendasServices vendasService ;
	
	@ApiOperation("Listar vendas")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Vendas>> listar(){
		List<Vendas> vendas = vendasService.listar();
		return ResponseEntity.status(HttpStatus.OK).body(vendas);
	}
	
	@RequestMapping(method = RequestMethod.POST )
	public ResponseEntity<Void> salvar(@ApiParam(value ="Salvar venda",example ="1")@Valid @RequestBody Vendas vendas){
	vendas = vendasService.salvar(vendas)	;
	URI uri= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(vendas.getId()).toUri();
	
	return ResponseEntity.created(uri).build(); 
	
	
	}
	
	@ApiOperation("Buscar venda por ID")
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Vendas>> buscar(@ApiParam(value ="Buscar venda por ID",example ="1")@PathVariable Long id){
		Optional<Vendas> vendas = vendasService.buscar(id);
		return ResponseEntity.status(HttpStatus.OK).body(vendas);
	}

    @DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@ApiParam(value ="Excluir venda por ID",example ="1")@PathVariable Long id){
    	vendasService.deletar(id);
		
		 return ResponseEntity.noContent().build();
		
	}
	  

	

		
  
}
