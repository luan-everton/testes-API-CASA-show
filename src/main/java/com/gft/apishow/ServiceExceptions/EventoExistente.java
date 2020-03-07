package com.gft.apishow.ServiceExceptions;

public class EventoExistente extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2408415496111853723L;


	public EventoExistente(String mensagem) {
		super(mensagem);
	}
	

	public EventoExistente(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}


