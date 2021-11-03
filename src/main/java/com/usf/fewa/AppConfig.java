package com.usf.fewa;

import com.usf.fewa.services.*;
import com.usf.fewa.services.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;

@Configuration
public class AppConfig {
	@Bean
	public SeedDirService seedService() {
		return new SeedDirServiceImpl();
	}
	
	@Bean
	public TestService testService() {
		return new TestServiceImpl();
	}
	
	@Bean
	public TagService tagService() {
		return new TagServiceImpl();
	}
	
	@Bean
	public PreviewService previewService() {
		return new PreviewServiceImpl();
	}
	
	@Bean
	public SearchService searchService() {
		return new SearchServiceImpl();
	}
	
	@Bean
	public DownloadService downloadService() {
		return new DownloadServiceImpl();
	}

	@Bean
	public UploadService uploadService() { return new UploadServiceImpl(); }

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
