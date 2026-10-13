package tn.esprit.projet.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI projetOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Projet API")
                        .version("v1")
                        .description("API de gestion des véhicules et agences"));
    }
}
