package com.fpoly.labso4.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
		return bCryptEncoder;
	}
	
	@Autowired
	public void configGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication().passwordEncoder(passwordEncoder()).withUser("admin").password("$2y$12$TZy4WM7mbGwzf.rf4YcrcOETcoMVJ.Y/z8UG.eVTULv5SI8z/hi0a").roles("ADMIN");
		auth.inMemoryAuthentication().passwordEncoder(passwordEncoder()).withUser("nguoidung1").password("$2y$12$TZy4WM7mbGwzf.rf4YcrcOETcoMVJ.Y/z8UG.eVTULv5SI8z/hi0a").roles("USER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests().antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')");
		http.authorizeRequests().antMatchers("/user/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')");
		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
		http.authorizeRequests().and()
		.formLogin().loginPage("/login")
		.loginProcessingUrl("/j_spring_security_login")
		.defaultSuccessUrl("/user")
		.failureForwardUrl("/login?message=error")
		.usernameParameter("username")
		.passwordParameter("password")
		.and().logout().logoutUrl("/j_spring_security_logout").logoutSuccessUrl("/login?message=logout");
	}
}
