package com.inti.config;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.inti.service.interfaces.IAppUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private IAppUserDetailsService appUserDetailsService;

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(appUserDetailsService);
	}
	protected void configure(final HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
			// Restriction des interfaces (à adapter selon le besoin)
				.antMatchers("/**").hasRole("ADMIN")
				.antMatchers("/tache/**").hasRole("AVOCAT")
				.antMatchers("/affaire/**").hasRole("AVOCAT")
				.antMatchers("/tribunal/**").hasRole("AVOCAT")
				.antMatchers("/dashboard/**").hasRole("AVOCAT")
				.antMatchers("/userAvocat/**").hasRole("AVOCAT")
				.antMatchers("/login*").permitAll()
				.anyRequest().authenticated()
			.and()
			.cors().and()
			// Affichage du formulaire si on accède à la page /login
			.formLogin()
				.loginProcessingUrl("/login")
			.and()
			// Deconnexion de l'application et suppression des cookies
			.logout()
				.logoutUrl("/logout")
				.deleteCookies("JSESSIONID").permitAll()
			.and()
			.httpBasic()
			.and();
			
	}
	
	@Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        configuration.setAllowedMethods(Arrays.asList("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}
