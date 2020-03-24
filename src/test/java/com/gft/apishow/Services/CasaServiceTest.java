package com.gft.apishow.Services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gft.apishow.domain.Casa;
import com.gft.apishow.repository.CasaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CasaServiceTest {
	
	@Autowired
	private CasaRepository casasRepository;

	@Test
	public void deveMostrarOTamanhoDaListaDeCasasDeShow() {
		List<Casa> casas = casasRepository.findAll();
		assertThat(casas.size()).isEqualTo(2);
	}
	
	@Test
	public void deveProcurarPorNomeDaCasaDeShow() {
		List<Casa> casa = casasRepository.findByNomeCasaContaining("Texas");
		assertEquals(casa.get(0).getNomeCasa(), "casa TexasClub");
	}

	
	@Test
	public void deveBuscarCasaDeShowPorId() {
		Optional<Casa> casa = casasRepository.findById((long) 2);
		assertEquals(casa.get().getNomeCasa(), "casa TexasClub");
	}



}
