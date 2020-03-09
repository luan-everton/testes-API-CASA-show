package com.gft.apishow.handler;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.gft.apishow.ServiceExceptions.CasaExistenteException;
import com.gft.apishow.ServiceExceptions.CasaShowNaoEncontradaException;
import com.gft.apishow.ServiceExceptions.EventoExistente;
import com.gft.apishow.ServiceExceptions.EventoNaoEncontrado;
import com.gft.apishow.ServiceExceptions.NenhumaVendaEncontrada;
import com.gft.apishow.ServiceExceptions.UsuarioExistente;
import com.gft.apishow.ServiceExceptions.UsuarioNaoEncontrado;
import com.gft.apishow.domain.DetalhesError;


@ControllerAdvice
public class ResorceExceptionHandler {
	
	@Autowired
	private MessageSource messageSource;
	
	
	@ExceptionHandler(CasaShowNaoEncontradaException.class)
	public ResponseEntity<DetalhesError>HandleCasaShowNaoEncontradaException(CasaShowNaoEncontradaException e, HttpServletRequest Request){
		
		
		DetalhesError erro = new DetalhesError();
		erro.setStatus(404l);
		erro.setTitulo("Casa de show Não encontrada");
		erro.setMensagemDesenvolvedor("http://errors.apiShow.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(CasaExistenteException.class)
	public ResponseEntity<DetalhesError>HandleCasaExistenteException
	(CasaExistenteException e, HttpServletRequest Request){
		
		
		DetalhesError erro = new DetalhesError();
		erro.setStatus(409l);
		erro.setTitulo("Casa de Show já existente");
		erro.setMensagemDesenvolvedor("http://errors.apiShow.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}
	@ExceptionHandler(EventoExistente.class)
	public ResponseEntity<DetalhesError>HandleEventoExistente(EventoExistente e, HttpServletRequest Request){
		
		
		DetalhesError erro = new DetalhesError();
		erro.setStatus(409l);
		erro.setTitulo("Evento ja cadastrado");
		erro.setMensagemDesenvolvedor("http://errors.apiShow.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(EventoNaoEncontrado.class)
	public ResponseEntity<DetalhesError>HandleEventoNaoEncontrado(EventoNaoEncontrado e, HttpServletRequest Request){
		
		
		DetalhesError erro = new DetalhesError();
		erro.setStatus(404l);
		erro.setTitulo("Evento não Encontrado");
		erro.setMensagemDesenvolvedor("http://errors.apiShow.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(UsuarioExistente.class)
	public ResponseEntity<DetalhesError>HandleUsuarioUsuarioExistente(UsuarioExistente e, HttpServletRequest Request){
		
		
		DetalhesError erro = new DetalhesError();
		erro.setStatus(409l);
		erro.setTitulo("Usuario ja existente");
		erro.setMensagemDesenvolvedor("http://errors.apiShow.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	
	@ExceptionHandler(UsuarioNaoEncontrado.class)
	public ResponseEntity<DetalhesError>HandleUsuarioNaoEncontrado(UsuarioNaoEncontrado e, HttpServletRequest Request){
		
		
		DetalhesError erro = new DetalhesError();
		erro.setStatus(404l);
		erro.setTitulo("Usuario não Encontrado");
		erro.setMensagemDesenvolvedor("http://errors.apiShow.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	
	
	@ExceptionHandler(InvalidFormatException.class)
	public ResponseEntity<DetalhesError>HandleInvalidFormatException(InvalidFormatException e, HttpServletRequest Request){
		
		
		DetalhesError erro = new DetalhesError();
		erro.setStatus(400l);
		erro.setTitulo("Requisição invalida, preencha os campos de forma correta ");
		erro.setMensagemDesenvolvedor("http://errors.apiShow.com/400");
		erro.setTimestamp(System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
	
	@ExceptionHandler(NenhumaVendaEncontrada.class)
	public ResponseEntity<DetalhesError>HandleNenhumaVendaEncontrada(NenhumaVendaEncontrada e, HttpServletRequest Request){
		
		
		DetalhesError erro = new DetalhesError();
		erro.setStatus(404l);
		erro.setTitulo("Nenhuma Venda foi encontrada");
		erro.setMensagemDesenvolvedor("http://errors.apiShow.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<DetalhesError>> handlerMethodArgumentNotValidException
	(MethodArgumentNotValidException e, HttpServletRequest request){
		
		List<DetalhesError> erro = new ArrayList();

		List<FieldError> erros = e.getBindingResult().getFieldErrors();
		
		erros.forEach(error -> {
			DetalhesError erroAtual = new DetalhesError();
			erroAtual.setStatus(400l);
			erroAtual.setTitulo("Requisição inválida.");
			erroAtual.setTimestamp(System.currentTimeMillis());
			String message = messageSource.getMessage(error, LocaleContextHolder.getLocale());
			erroAtual.setMessage(message);
			erro.add(erroAtual);
		});
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
	
	
	
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<DetalhesError>HandleDataIntegrityViolationException(DataIntegrityViolationException e, HttpServletRequest Request){
		
		
		DetalhesError erro = new DetalhesError();
		erro.setStatus(400l);
		erro.setTitulo("Requisição invalida");
		erro.setMensagemDesenvolvedor("http://errors.apiShow.com/400");
		erro.setTimestamp(System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
	
	

}

