package com.carritodecompras.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	
	@Bean 
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)throws Exception {
		
		httpSecurity.authorizeHttpRequests(http ->http
				.requestMatchers("/css/**","/images/**","/js/**")
				.permitAll()
				.requestMatchers("/carritodecompras/","carritodecompras/inicio","carritodecompras/registro")
				.permitAll()
				.requestMatchers("carritodecompras/principal/")
				.hasAnyAuthority("Cliente","Vendedor")
				.requestMatchers("carritodecompras/cliente/**")
				.hasAuthority("Cliente")
				.requestMatchers("carritodecompras/vendedor/**")
				.hasAuthority("Vendedor")
				.requestMatchers("/carritodecompras/","/carritodecompras/inicio","/carritodecompras/registro")
				.anonymous()
				.anyRequest()
				.authenticated()
				)
		
		.formLogin(l-> l
				.loginPage("/carritodecompras/inicio") 
				.permitAll());
		
		return httpSecurity.build();
	}
	
	
	/**
	 * 
	 * @return el bean configurado para recuperar las contraseñas encriptadas.
	 */
	@Bean
	PasswordEncoder passwordEncoder () {
		return new BCryptPasswordEncoder();
	}
	
}
