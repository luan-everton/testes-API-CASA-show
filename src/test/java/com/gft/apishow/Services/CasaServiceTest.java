 package com.gft.apishow.Services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gft.apishow.domain.Casa;
import com.gft.apishow.repository.CasaRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE )
public class CasaServiceTest {
	
	private Casa casa;
	
	@Autowired
	private CasaRepository casasRepository;
	

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setup() {
		casa = new Casa("Casa de show", "Endereço");
	}
	@Test
	public void deveSalvarCasaDeShow() {
		casasRepository.save(casa);
		assertThat(casa.getId()).isNotNull();
		assertThat(casa.getNomeCasa()).isEqualTo("Casa de show");
	}
	@Test
	public void deveEditarCasa() {
		casasRepository.save(casa);
		casa.setNomeCasa("Casa Rio");
		casa.setLocal("Interlagos");
		casasRepository.save(casa);
		assertThat(casa.getNomeCasa()).isEqualTo("Casa Rio");
		assertEquals(casa.getLocal(), "Interlagos");
		//System.out.println(casa.getNome());
	}
	
	
	
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
