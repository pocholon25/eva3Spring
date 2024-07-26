package com.idat.semana8.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idat.semana8.dto.UsuarioDtoResponse;
import com.idat.semana8.dto.UsuarioRegistroDtoRequest;
import com.idat.semana8.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	@GetMapping
	public ResponseEntity<?>hola(Principal principal){
		return new ResponseEntity<>("Hola "+principal.getName(),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<UsuarioDtoResponse>registrar(@RequestBody UsuarioRegistroDtoRequest usu){
		return new ResponseEntity<>(service.registrar(usu),HttpStatus.OK);
	}
}
