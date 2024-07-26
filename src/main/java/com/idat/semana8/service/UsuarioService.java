package com.idat.semana8.service;

import com.idat.semana8.dto.UsuarioDtoResponse;
import com.idat.semana8.dto.UsuarioRegistroDtoRequest;

public interface UsuarioService {
	
	UsuarioDtoResponse registrar (UsuarioRegistroDtoRequest usuario);

}
