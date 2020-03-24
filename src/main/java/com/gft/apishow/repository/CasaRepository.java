package com.gft.apishow.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gft.apishow.domain.Casa;

public interface CasaRepository extends JpaRepository<Casa, Long>{
	
	

	List<Casa> findByNomeCasaContaining(String nomeCasa);
	

}
