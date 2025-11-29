package com.rollerspeed.rollerspeed.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
           
            .csrf(csrf -> csrf.disable())
            .httpBasic(httpBasic -> httpBasic.disable())
            .formLogin(form -> form.disable())

            .authorizeHttpRequests(auth -> auth
                // ✔ Páginas públicas
                .requestMatchers(
                        "/", "/index", "/mision", "/vision", "/valores",
                        "/servicios", "/eventos", "/noticias", "/clases",
                        "/auth/**",
                        "/css/**", "/js/**", "/images/**"
                ).permitAll()

                // ✔ Acceso por rol (tú controlas esto después del login manual)
                .requestMatchers("/admin/**").permitAll()
                .requestMatchers("/instructor/**").permitAll()
                .requestMatchers("/alumno/**").permitAll()

                // ✔ Todo lo demás también permitido
                .anyRequest().permitAll()
            );

        return http.build();
    }
}
