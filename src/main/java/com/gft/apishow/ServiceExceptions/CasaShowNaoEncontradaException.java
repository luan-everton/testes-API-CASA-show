package com.gft.apishow.ServiceExceptions;

public class CasaShowNaoEncontradaException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5800669614251246444L;


	public CasaShowNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	

	public CasaShowNaoEncontradaException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}


