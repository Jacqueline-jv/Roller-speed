package com.rollerspeed.rollerspeed.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("RollerSpeed API")
                        .version("1.0.0")
                        .description("Documentación de la API de RollerSpeed para gestión de usuarios, celdas, vehículos y pagos.")
                        .contact(new Contact()
                                .name("Equipo RollerSpeed")
                                .email("soporte@rollerspeed.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")));
    }
}
