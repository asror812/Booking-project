package com.example.bookingplatform.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        return   httpSecurity.authorizeHttpRequests(
                registry -> registry
                        .requestMatchers("/auth/register", "/auth/login", "/auth/phoneNumber" , "/css/**")
                        .permitAll()
                        .anyRequest()
                        .authenticated()
        )
                .formLogin(
                        loginConfigurer -> loginConfigurer
                                .loginPage("/auth/login")
                                .loginProcessingUrl("/auth/login")
                                .usernameParameter("phoneNumber")
                                .passwordParameter("password")
                                .defaultSuccessUrl("/")
                )
                .logout(
                        config -> config
                                .logoutSuccessUrl("/auth/login")
                                .logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout"))
                )
                .rememberMe(
                        config -> config
                                .rememberMeCookieName("rememberMe")
                                .rememberMeParameter("rememberMe")
                )
                .build();/* httpSecurity
                .authorizeHttpRequests(
                        registry -> registry
                                .requestMatchers("/auth/login" , "auth/register" , "auth/**" )
                                .permitAll()
                                .anyRequest()
                                .authenticated()
                )
               .formLogin(
                        loginConfigurer -> loginConfigurer
                                .loginPage("/auth/login")
                                .loginProcessingUrl("/auth/login")
                                .usernameParameter("phoneNumber")
                                .passwordParameter("password")
                                .defaultSuccessUrl("/")
                )
                .logout(
                        config -> config
                                .logoutSuccessUrl("/auth/logout")
                                .logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout"))
                )
                .build();*/
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
