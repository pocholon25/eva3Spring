package com.idat.semana8.config.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.idat.semana8.service.UserDetailsImpl;

import io.jsonwebtoken.*;


@Component
public class JwtUtils {

	private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
	
	@Value("${demo.api.jwtSecret}")
	private String jwtSecret;
	@Value("${demo.api.jwtExpirationMs}")
	private int jwtExpirationMs;
	
	public String generateJwtToken(Authentication authentication) {
		UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
		
		Map<String, Object>moreClaims = new HashMap<>();
		moreClaims.put("roles", userPrincipal.getAuthorities().stream().map(r->r.getAuthority()).collect(Collectors.toList()));
		
		return Jwts.builder()
				.setSubject(userPrincipal.getUsername())
				.addClaims(moreClaims)
				.setIssuedAt(new Date())
				.setExpiration(new Date((new Date().getTime()+jwtExpirationMs)))
				.signWith(SignatureAlgorithm.HS512, jwtSecret)
				.compact();	
	}
	public String getUserNameFromJwtToken(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}
	
	
	public boolean ValidateJwtToken(String token) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
			return true;
		} catch (SignatureException e) {
			logger.error("Invalid JWT Signature: {}",e.getMessage());
		}catch (MalformedJwtException e) {
			logger.error("Invalid JWT Token: {}",e.getMessage());
		}catch (ExpiredJwtException e) {
			logger.error("Token Expirado: {}",e.getMessage());
		}catch (IllegalArgumentException e) {
			logger.error("Permisos vacios: {}",e.getMessage());
		}catch (UnsupportedJwtException e) {
			logger.error("Token no soportado: {}",e.getMessage());
		}
		return false;
	}
	
	
	
	
	
	
	
	
}
