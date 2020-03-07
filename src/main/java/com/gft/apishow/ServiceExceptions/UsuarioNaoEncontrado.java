package com.gft.apishow.ServiceExceptions;

public class UsuarioNaoEncontrado extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5126242417846526221L;


	public UsuarioNaoEncontrado(String mensagem) {
		super(mensagem);
	}
	

	public UsuarioNaoEncontrado(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}