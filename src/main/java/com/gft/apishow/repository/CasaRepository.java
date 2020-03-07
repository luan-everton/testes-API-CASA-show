package com.gft.apishow.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.gft.apishow.domain.Casa;

public interface CasaRepository extends JpaRepository<Casa, Long>{
	
	Casa findByNomeCasa(String nomeCasa);
	

}
