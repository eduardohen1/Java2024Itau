package br.com.ehmf.AppProdutos.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.authorizeHttpRequests((authz) -> authz
					    .requestMatchers("/token", "/v3/api-docs/**", "/swagger-ui/**", 
					    		"/swagger-ui.html", "/swagger-resources/**", 
					    		"/webjars/**").permitAll()
						.anyRequest().authenticated())
			.addFilterBefore(jwtTokenFilter(), 
					UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}
	
	//bean para o filtro JWT
	@Bean
	public JwtTokenFilter jwtTokenFilter() {
		return new JwtTokenFilter();
	}
	
}
