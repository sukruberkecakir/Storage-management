package com.deneme.demo.Service

import javax.sql.DataSource

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Configuration
@EnableWebSecurity
class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	@Bean
	UserDetailsService userDetailsService() {
		return new CustomUserDetailsService()
	}
	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder()
	}
	@Bean
	DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider()
		daoAuthenticationProvider.setUserDetailsService(userDetailsService())
		daoAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder())
		
		return daoAuthenticationProvider
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {	
		http.authorizeRequests()
			.antMatchers("/register").permitAll()
			.antMatchers("/register_succeded").permitAll()
            .antMatchers("/").permitAll()
			.antMatchers("/products").permitAll()
			.antMatchers("/usersList").hasAnyAuthority("ADMIN")
            .antMatchers("/add_product").hasAnyAuthority("ADMIN")
            .antMatchers("/edit/**").hasAnyAuthority("ADMIN")
            .antMatchers("/delete/**").hasAuthority("ADMIN")
				.anyRequest().authenticated()
				http.formLogin().successForwardUrl("/")
				.and().logout().logoutSuccessUrl("/").permitAll()
				.and().exceptionHandling().accessDeniedPage("/403")		
	}
}







