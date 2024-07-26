package com.idat.semana8.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idat.semana8.model.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Long>{
	
	Optional<Usuario> findByLogin(String login);

}










