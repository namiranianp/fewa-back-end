package com.usf.fewa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;

import com.usf.fewa.services.PreviewService;
import com.usf.fewa.services.SearchService;
import com.usf.fewa.services.SeedDirService;
import com.usf.fewa.services.TagService;
import com.usf.fewa.services.TestService;
import com.usf.fewa.services.impl.PreviewServiceImpl;
import com.usf.fewa.services.impl.SearchServiceImpl;
import com.usf.fewa.services.impl.SeedDirServiceImpl;
import com.usf.fewa.services.impl.TagServiceImpl;
import com.usf.fewa.services.impl.TestServiceImpl;

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
	public PreviewService downloadService() {
		return new DownloadServiceImpl();
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
