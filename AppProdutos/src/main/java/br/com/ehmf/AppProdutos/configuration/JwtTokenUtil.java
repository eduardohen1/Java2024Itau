package br.com.ehmf.AppProdutos.configuration;

import java.security.Key;
import java.util.Base64;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenUtil {
	
	private String secret = "umSegredoMuitoLongoQueTemMaisDe256BitsParaSerSeguroComHMACSHA"; //256
	private long validadeMilisegundos = 3600000; //1h
	
	///criar o token
	public String createToken(String username) {
		Date agora = new Date();
		Date validade = new Date(agora.getTime() + validadeMilisegundos);
		
		byte[] apiKeySecretByte = Base64.getEncoder().encode(secret.getBytes());
		Key secretKey = Keys.hmacShaKeyFor(apiKeySecretByte);
		
		return Jwts.builder()
				.setSubject(username)
				.setIssuedAt(agora)
				.setExpiration(validade)
				.signWith(secretKey)
				.compact();		
	}
	
	public boolean validateToken(String token) {
		try {
			byte[] apiKeySecretByte = Base64.getEncoder().encode(secret.getBytes());
			Key secretKey = Keys.hmacShaKeyFor(apiKeySecretByte);
			
			Jws<Claims> claims = Jwts.parser().setSigningKey(apiKeySecretByte)
					.parseClaimsJws(token);	//quebrei token em objetos
			return !claims.getBody().getExpiration().before(new Date());			
			
		} catch (Exception e) {
			return false;
		}
	}
	
	//validar o token
	
}
