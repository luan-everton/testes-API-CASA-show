package com.gft.apishow.ServiceExceptions;

public class CasaExistenteException extends RuntimeException {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1353514741250697566L;


	public CasaExistenteException(String mensagem) {
		super(mensagem);
	}
	

	public CasaExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}


