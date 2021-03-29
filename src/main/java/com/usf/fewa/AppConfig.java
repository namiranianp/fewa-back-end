package com.usf.fewa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;

import com.usf.fewa.services.JPEGContentService;
import com.usf.fewa.services.JsonTestService;
import com.usf.fewa.services.MP4ContentService;
import com.usf.fewa.services.PDFContentService;
import com.usf.fewa.services.PNGContentService;
import com.usf.fewa.services.TXTContentService;
import com.usf.fewa.services.TagTestService;
import com.usf.fewa.services.TestService;
import com.usf.fewa.services.impl.JPEGContentServiceImpl;
import com.usf.fewa.services.impl.JsonTestServiceImpl;
import com.usf.fewa.services.impl.MP4ContentServiceImpl;
import com.usf.fewa.services.impl.PDFContentServiceImpl;
import com.usf.fewa.services.impl.PNGContentServiceImpl;
import com.usf.fewa.services.impl.TXTContentServiceImpl;
import com.usf.fewa.services.impl.TagTestServiceImpl;
import com.usf.fewa.services.impl.TestServiceImpl;

@Configuration
public class AppConfig {
	@Bean
	public TestService testService() {
		return new TestServiceImpl();
	}
	
	@Bean
	public JsonTestService jsonTestService() {
		return new JsonTestServiceImpl();
	}
	
	@Bean
	public JPEGContentService jpegContentService() {
		return new JPEGContentServiceImpl();
	}
	
	@Bean
	public MP4ContentService mp4ContentService() {
		return new MP4ContentServiceImpl();
	}
	
	@Bean
	public PDFContentService pdfContentService() {
		return new PDFContentServiceImpl();
	}
	
	@Bean
	public PNGContentService pngContentService() {
		return new PNGContentServiceImpl();
	}
	
	@Bean
	public TXTContentService txtContentService() {
		return new TXTContentServiceImpl();
	}
	
	@Bean
	public TagTestService tagTestService() {
		return new TagTestServiceImpl();
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
