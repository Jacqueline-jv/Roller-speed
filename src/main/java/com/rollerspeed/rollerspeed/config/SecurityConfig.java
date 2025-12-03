package com.rollerspeed.rollerspeed.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // Bean para encriptar contraseñas
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // CONFIGURACIÓN DE SEGURIDAD
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll()   // Permitir TODOS 
            )
            .csrf(csrf -> csrf.disable())        // desactivar CSRF
            .formLogin(form -> form.disable())   // desactivar login por formulario
            .httpBasic(basic -> basic.disable()) // desactivar basic auth
            .logout(logout -> logout.disable()); // desactivar logout

        return http.build();
    }
}

