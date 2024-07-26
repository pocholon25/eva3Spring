package com.idat.semana8.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idat.semana8.dto.LoginDtoRequest;
import com.idat.semana8.service.AutenticacionService;

@RestController
@RequestMapping("/security")
public class AuthenticationController {
	
	@Autowired
	private AutenticacionService authServ;

	@PostMapping
	public ResponseEntity<?>login(@RequestBody LoginDtoRequest loginDto){
		System.out.println(loginDto.toString());
		return ResponseEntity.ok(authServ.autenticar(loginDto));
	}
}
