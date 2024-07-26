package com.idat.semana8.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.idat.semana8.dao.UsuarioDao;
import com.idat.semana8.model.Usuario;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UsuarioDao dao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usu = dao.findByLogin(username).orElseThrow(()->new UsernameNotFoundException("Usuario no encontrado con login" + username));
		
		return UserDetailsImpl.build(usu);
	}
	

}
