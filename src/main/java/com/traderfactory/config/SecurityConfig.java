package com.traderfactory.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	public void configureGlobal1(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic()
			.disable()
		.authorizeRequests()
			.antMatchers(HttpMethod.GET, "/").permitAll()
			.antMatchers(HttpMethod.GET, "/hello").permitAll()
			.antMatchers(HttpMethod.GET, "/aux").permitAll()
			.antMatchers(HttpMethod.GET, "/books/*").permitAll()
			.antMatchers(HttpMethod.GET, "/zen").hasRole("ADMIN")
			.antMatchers(HttpMethod.GET, "/shoot").hasRole("ADMIN")
			.anyRequest().authenticated()
			.and()
		.csrf()
			.disable();
	}

}














