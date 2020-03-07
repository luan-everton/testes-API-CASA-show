package com.gft.apishow.ServiceExceptions;

public class UsuarioExistente extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2408415496111853723L;


	public UsuarioExistente(String mensagem) {
		super(mensagem);
	}
	

	public UsuarioExistente(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}



