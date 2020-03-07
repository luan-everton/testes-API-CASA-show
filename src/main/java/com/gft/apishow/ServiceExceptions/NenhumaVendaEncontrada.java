package com.gft.apishow.ServiceExceptions;

public class NenhumaVendaEncontrada extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5126242417846526221L;


	public NenhumaVendaEncontrada(String mensagem) {
		super(mensagem);
	}
	

	public NenhumaVendaEncontrada(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
