package com.gft.apishow.ServiceExceptions;

public class EventoNaoEncontrado extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5126242417846526221L;


	public EventoNaoEncontrado(String mensagem) {
		super(mensagem);
	}
	

	public EventoNaoEncontrado(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}




