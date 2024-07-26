package com.idat.semana8.dto;

import java.util.List;

public class JwtDtoResponse {
	
	private UsuarioDtoResponse usuario;
	private String accessToken;
	private String tokenType;
	
	
	
	public JwtDtoResponse(String jwt,UsuarioDtoResponse usu,  List<String>roles) {
		super();
		this.usuario = usu;
		this.accessToken = jwt;
		this.tokenType = "Bearer";
	}
	public UsuarioDtoResponse getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioDtoResponse usuario) {
		this.usuario = usuario;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getTokenType() {
		return tokenType;
	}
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}
	
	

}
