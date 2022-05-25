package com.tanja.web_customer_tracker.security;

import javax.sql.DataSource;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.tanja.web_customer_tracker.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		UserBuilder users = User.builder();
//		auth
//			.inMemoryAuthentication()
//			.passwordEncoder(passwordEncoder())
//			.withUser(users.username("admin@admin.com").password(passwordEncoder().encode("admin")).roles("ADMIN"));
		auth
			.jdbcAuthentication()
//			.passwordEncoder(passwordEncoder())
			.dataSource(dataSource)
			.usersByUsernameQuery("select email, password, enabled from users where email=?")
			.authoritiesByUsernameQuery("select email, authority from authorities where email=?");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("authtjrhsjfks");
		
		http.authorizeRequests()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
//		.loginPage("/login")
//		.loginProcessingUrl("/processLogin")
//		.defaultSuccessUrl("/")
		.permitAll()
		.and()
		.logout()
		.permitAll();
	}
		
}
