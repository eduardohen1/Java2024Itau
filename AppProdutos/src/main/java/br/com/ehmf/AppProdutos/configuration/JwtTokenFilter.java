package br.com.ehmf.AppProdutos.configuration;

import java.io.IOException;

import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtTokenFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, 
			FilterChain filterChain)
			throws ServletException, IOException {
		
		//Extrair o token do cabeçalho da requisição
		
		//Validar o token
		
		//se válido, configurar a autenticação no contexto
		
		filterChain.doFilter(request, response);
		
	}

}
