package com.usf.fewa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;

import com.usf.fewa.services.SeedDirService;
import com.usf.fewa.services.TestService;
import com.usf.fewa.services.impl.SeedDirServiceimpl;
import com.usf.fewa.services.impl.TestServiceImpl;

@Configuration
public class AppConfig {
	@Bean
	public SeedDirService seedService() {
		return new SeedDirServiceimpl();
	}
	
	@Bean
	public TestService testService() {
		return new TestServiceImpl();
	}

	@Bean
	public String userDirLocation() {
		return "./src/main/resources/users/";
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	

	@Bean
	public SpringSecurityDialect springSecurityDialect() {
		return new SpringSecurityDialect();
	}
}
