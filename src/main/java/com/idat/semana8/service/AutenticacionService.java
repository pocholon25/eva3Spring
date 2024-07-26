package com.idat.semana8.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.idat.semana8.config.jwt.JwtUtils;
import com.idat.semana8.dto.JwtDtoResponse;
import com.idat.semana8.dto.LoginDtoRequest;
import com.idat.semana8.dto.UsuarioDtoResponse;

@Component
public class AutenticacionService {

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtUtils jwtUtils;
	
	public JwtDtoResponse autenticar(LoginDtoRequest loginDto) {
		Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getLogin(),loginDto.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(auth);
		String jwt = jwtUtils.generateJwtToken(auth);
		UserDetailsImpl userDetails=(UserDetailsImpl) auth.getPrincipal();
		List<String>roles=userDetails.getAuthorities().stream().map(item->item.getAuthority()).collect(Collectors.toList());
		
		UsuarioDtoResponse dtoU = new UsuarioDtoResponse();
		dtoU.setApellidos(userDetails.getApellidos());
		dtoU.setLogin(userDetails.getLogin());
		dtoU.setNombres(userDetails.getNombres());
		return new JwtDtoResponse(jwt,dtoU,roles);
	}
}
