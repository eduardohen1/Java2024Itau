package br.com.ehmf.AppProdutos.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.components(
						new Components().addSecuritySchemes("bearerAuth", 
								new SecurityScheme().type(SecurityScheme.Type.HTTP)
									.scheme("bearer").bearerFormat("JWt")))
				.info(new Info()
						.title("App de cadastro de produtos e estoque")
						.description("Este aplicativo faz controle de cadastro de produtos "
								+ "bem como o cadastro de seu respectivo estoque.")
						.contact(new Contact()
									.name("MEU NOME")
									.email("EMAIL@EMAIL.COM")
									.url("http://localhost")
								)
						.version("Versão 0.0.1-SNAPSHOT")
				)
				.addSecurityItem(new SecurityRequirement().addList("bearerAuth"));
	}	
	
}
