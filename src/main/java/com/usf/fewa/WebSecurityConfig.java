package com.usf.fewa;

import java.util.Arrays;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.header.writers.frameoptions.WhiteListedAllowFromStrategy;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO not secure but needed for separate front/back end
//		super.configure(http);
		http.csrf().disable();
		http.headers().frameOptions().disable();
//		http.headers().frameOptions().sameOrigin();
//		http.headers().addHeaderWriter(new XFrameOptionsHeaderWriter(
//				new WhiteListedAllowFromStrategy(Arrays.asList("http://localhost:3000"))));
	}
}