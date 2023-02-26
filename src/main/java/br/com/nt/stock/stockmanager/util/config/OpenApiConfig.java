/**
 * 
 */
package br.com.nt.stock.stockmanager.util.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

/**
 * @author Neto
 *
 */
@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("API Documentation").version("1.0").description("Documentation for the API"));
	}
}
