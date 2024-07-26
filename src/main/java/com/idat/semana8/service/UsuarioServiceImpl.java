package com.idat.semana8.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.idat.semana8.dao.UsuarioDao;
import com.idat.semana8.dto.UsuarioDtoResponse;
import com.idat.semana8.dto.UsuarioRegistroDtoRequest;
import com.idat.semana8.model.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UsuarioDao dao;

	@Override
	public UsuarioDtoResponse registrar(UsuarioRegistroDtoRequest usuario) {
		
		Usuario usu = new Usuario();
		usu.setApellidos(usuario.getApellidos());
		usu.setNombres(usuario.getNombres());
		usu.setLogin(usuario.getLogin());
		usu.setClave(passwordEncoder.encode(usuario.getClave()));
		
		usu = dao.save(usu);
		
		UsuarioDtoResponse res = new UsuarioDtoResponse();
		res.setApellidos(usu.getApellidos());
		res.setNombres(usu.getNombres());
		res.setLogin(usu.getLogin());
		
		return res;
	}

}
