package com.gft.apishow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gft.apishow.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
