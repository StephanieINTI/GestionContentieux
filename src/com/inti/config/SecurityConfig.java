package com.inti.config;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
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
				.antMatchers("/utilisateur/admin/**").hasRole("ADMIN")
				.antMatchers("/tache/**").hasRole("AVOCAT")
				.antMatchers("/affaire/**").permitAll()
				.antMatchers("/tribunal/**").permitAll()
				.antMatchers("/login*").permitAll()
				.anyRequest().authenticated()
			.and()
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
	public FilterRegistrationBean simpleCorsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		config.setAllowedMethods(Collections.singletonList("*"));
		config.setAllowedHeaders(Collections.singletonList("*"));
		source.registerCorsConfiguration("/**", config);
		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}

}
