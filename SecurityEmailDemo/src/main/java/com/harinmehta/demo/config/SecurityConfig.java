package com.harinmehta.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource securityDataSource;
	
	@Override
	public void configure(HttpSecurity http) throws Exception{
	
		http
			.authorizeRequests()
			.antMatchers("/api/register").permitAll()
			.antMatchers("/api/login").hasRole("EMPLOYEE")
			.antMatchers("/api/changePassword").hasRole("EMPLOYEE")
			.anyRequest().authenticated()
			.and()
			.httpBasic()
			.and()
			.logout().permitAll()
			.and()
			.csrf().disable();
		
	}
	
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
		
		auth
			.jdbcAuthentication().dataSource(securityDataSource);
		
	}
	
	@Bean
	public UserDetailsManager userDetailsManager() {
		
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
		jdbcUserDetailsManager.setDataSource(securityDataSource);
		return jdbcUserDetailsManager;
	}
	
}
