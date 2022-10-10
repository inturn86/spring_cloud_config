package com.sdc.userservice.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.sdc.userservice.service.UserService;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurity extends WebSecurityConfigurerAdapter{

	private final UserService userService;

	private final BCryptPasswordEncoder encoder;

	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable();
//		http.authorizeRequests().antMatchers("/users/**").permitAll();
		http.authorizeRequests().antMatchers("/**")
		.hasIpAddress("218.155.198.195")
		.and()
		.addFilter(getAuthenticationFilter());

		http.headers().frameOptions().sameOrigin();
	}

	private AuthenticationFilter getAuthenticationFilter() throws Exception {

		AuthenticationFilter af = new AuthenticationFilter();
		af.setAuthenticationManager(authenticationManager());

		return af;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userService).passwordEncoder(encoder);
	}
}
