package br.gov.sc.sctec.empreendedorismo.backend.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("SCTEC - Desafio Técnico - Backend API") // Set the title here
                        .version("1.0.0")
                        .summary("Backend API implementada para o desafio técnico do programa SCTEC.")
                        .description("")
                        .contact(new Contact()
                                .name("Daniel Rodrigues da Silva")
                                .email("danielsilva@ciasc.sc.gov.br")
                                .url("https://github.com/tiodanas/desafio-tecnico-sctec"))
                );
    }

}
