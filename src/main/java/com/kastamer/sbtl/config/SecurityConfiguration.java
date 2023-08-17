package com.kastamer.sbtl.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.kastamer.sbtl.service.EmpService;

@Configuration
//@PropertySource(value = "classpath:application.properties")
@EnableWebSecurity
public class SecurityConfiguration { //extends WebSecurityConfiguration { // extends WebSecurityConfigurerAdapter {

//	private final EmpService empService;
//	
//	public SecurityConfiguration(EmpService empService) {
//		//super();
//		this.empService = empService;
//	}
	//	@Lazy --> NOT WORKING
	@Bean
	public static BCryptPasswordEncoder passwordEncoder() {
		// TODO Auto-generated method stub
		return new BCryptPasswordEncoder();
	}
	
//	@Lazy --> NOT WORKING
	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		// AuthenticationManagerBuilder authManBuild = http.getSharedObject(AuthenticationManagerBuilder.class);
		
		http.authorizeHttpRequests((requests) -> requests.requestMatchers(
				"/registrasi",
				"/js**",
				"/css**",
				"/img**")
				.permitAll().anyRequest().authenticated())
		.formLogin((form) -> form.loginPage("/login").permitAll())
		.logout((logout) -> logout.invalidateHttpSession(true).clearAuthentication(true).logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login?logout").permitAll());
		
		return http.build();
	}
	/*
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(http);
		http.authorizeRequests().antMatchers(
				"/registrasi",
				"/js**",
				"/css**",
				"/img**"
				).permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/login").permitAll()
		.and()
		.logout()
			.invalidateHttpSession(true)
			.clearAuthentication(true)
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/login?logout")
			.permitAll();
	}
	*/
}
