package com.gft.apishow.builders;

import com.gft.apishow.domain.Casa;

public class CasaBuilder {




	private Casa casa;
	
	private CasaBuilder() {}
	
	public static CasaBuilder umaCasa() {
		CasaBuilder builder = new CasaBuilder();
		builder.casa = new Casa();
		builder.casa.setNomeCasa("Casa Euphoria");
		builder.casa.setLocal("Bandeirantes");
		
		return builder;
	}
	
	public Casa agora() {
		return casa;
	}
}


