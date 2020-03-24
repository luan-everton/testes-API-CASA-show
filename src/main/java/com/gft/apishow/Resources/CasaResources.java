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

import com.gft.apishow.Services.CasaServices;
import com.gft.apishow.domain.Casa;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@Api(tags ="Casas")
@RestController
@RequestMapping("/casas")
public class CasaResources{

	@Autowired
	private CasaServices casaService ;
	
	@ApiOperation("Listar todas casas de show")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Casa>> listar() {
		List<Casa> casas = casaService.listar();
		return ResponseEntity.status(HttpStatus.OK).body(casas);
	}
	
	@ApiOperation("Inserir casa de show")
	@RequestMapping(method = RequestMethod.POST )
	public ResponseEntity<Void> salvar(@ApiParam(value ="Nome da casa ",example =" Texas Club")	@Valid @RequestBody Casa casa){
	casa = casaService.salvar(casa)	;
	URI uri= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(casa.getId()).toUri();
	
	return ResponseEntity.created(uri).build(); 
	
	
	}
	@ApiOperation("Buscar casa por ID")
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Casa>> buscar(@ApiParam(value ="Id de uma casa ",example ="1")@PathVariable Long id){
		Optional<Casa> casa = casaService.buscar(id);
		return ResponseEntity.status(HttpStatus.OK).body(casa);
	}

	@ApiOperation("Excluir casa de show")
    @DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@ApiParam(value ="Excluir casa por ID",example ="1")@PathVariable Long id){
		casaService.deletar(id);
		
		 return ResponseEntity.noContent().build();
		
	}
	  

	@ApiOperation("Atualizar Casa de show")
	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar (@ApiParam(value ="Id da casa ",example ="1")@RequestBody Casa casa,  @PathVariable("id")  Long id) {

		casa.setId(id);
		casaService.atualizar(casa);
		
		return ResponseEntity.noContent().build();
		
  }
	@ApiOperation("Listar as Casas de em ordem alfabética crescente por nome")
	@RequestMapping(value="/asc",method = RequestMethod.GET)
	public ResponseEntity<List<Casa>>listarCasaCrescente(){
		return ResponseEntity.status(HttpStatus.OK).body(casaService.listarCrescente());
	}
	

	@ApiOperation("Listar as Casas de em ordem alfabética decrescente por nome")
	@RequestMapping(value="/desc",method = RequestMethod.GET)
	public ResponseEntity<List<Casa>>listarCasadecrecente(){
		return ResponseEntity.status(HttpStatus.OK).body(casaService.listarDecrecente());
	}
		
	@ApiOperation("Buscar casa por nome")
	@GetMapping("/nome/{nomeCasa}")
	public ResponseEntity<List<Casa>> listarporCasaNome( @PathVariable("nomeCasa")String nomeCasa){
		
		return ResponseEntity.status(HttpStatus.OK).body(casaService.buscarPorNome(nomeCasa));
		}
	}
	
	
