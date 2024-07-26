package com.idat.semana8.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.idat.semana8.model.Usuario;

public class UserDetailsImpl implements UserDetails{
	
	private Long id;
	private String login;
	private String nombres;
	private String apellidos;
	private String password;
	private Collection<? extends GrantedAuthority> authorities;
	
	public UserDetailsImpl(Long id, String login, String nombres, String apellidos, String password,
			Collection<? extends GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.login = login;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.password = password;
		this.authorities = authorities;
	}
	
	public static UserDetailsImpl build(Usuario usuario) {
		
		SimpleGrantedAuthority CLIENTE_ROLE = new SimpleGrantedAuthority("USUARIO_ROLE");
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(CLIENTE_ROLE);
		
		return new UserDetailsImpl(usuario.getId(), usuario.getLogin(), usuario.getNombres(),usuario.getApellidos(), usuario.getClave(),authorities);		
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	
	
	@Override
	public String getPassword() {
		return password;
	}
	
	@Override
	public String getUsername() {
		return login;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	

}
