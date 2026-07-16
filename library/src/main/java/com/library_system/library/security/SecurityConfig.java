package com.library_system.library.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .csrf(csrf -> csrf.disable()) // Desabilita proteção contra CSRF para APIs REST
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // API sem guardar estado no servidor
            .authorizeHttpRequests(authorize -> authorize

                // Aqui você diz: "Para criar usuários (POST /usuarios), permita todos (permitAll)"
                .requestMatchers(HttpMethod.POST, "/usuarios").permitAll()
                .requestMatchers(HttpMethod.POST, "/livros").permitAll()
                .requestMatchers(HttpMethod.POST, "/exemplares").permitAll()
                .requestMatchers(HttpMethod.POST, "/emprestimos").permitAll()

                // Libera também a rota de fazer login que você tem no seu AuthController
                .requestMatchers(HttpMethod.POST, "/api/auth/login").permitAll()
                // Qualquer outra requisição vai exigir que o usuário esteja logado
                .anyRequest().authenticated()
            )
            .build();
    }
}
