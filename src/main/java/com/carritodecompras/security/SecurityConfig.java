package com.carritodecompras.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	/**
	 * obtenemos el nombre la contraseña y el rol del usuario que intenete ingresar
	 * 
	 * @return los detalles del usuario al que le corresponda el username en la base de datos
	 */
	@Bean
	UserDetailsManager userDetailsManager () {
		JdbcUserDetailsManager jdbcUserDetailsManager=new JdbcUserDetailsManager(dataSource);
		
		//se obtiene el usuario la contraseña y el estado del usuario desde la base de datos
		jdbcUserDetailsManager.setUsersByUsernameQuery("SELECT u.correoElectronico as username, u.password, u.activo from usuarios as u where u.correoElectronico=?");
		
		// se obtiene el username del usuario y una coleccion de las authorities que puede tener el usuario
		jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("SELECT  u.correoElectronico,  r.nombre FROM usuarios as u  "
															+ "INNER JOIN roles as r on r.Id=u.IdRol  "
															+ "WHERE u.correoElectronico= ?");
		return jdbcUserDetailsManager;
	}
	
	/**
	 * metodo que configura el bean SecurityFilterChain para personalizar la autorizacion en la aplicacion
	 * 
	 * @param httpSecurity es un bean que sera personalizado a las necesidades de la aplicacion
	 * @return el bean SecurityFilterChain con todas las url que se quieren proteger en la aplicacion
	 * @throws Exception en caso de fallar la operacion de construccion del bean httpSecurity
	 */
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
	
	
	@Autowired
	private DataSource dataSource;
}
