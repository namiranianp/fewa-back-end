package com.usf.fewa;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class App implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	/**
	 * THIS IS ESSENTIAL TO BE ABLE TO ACCESS FILES OUTSIDE OF ROOT RESOURCE
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addResourceHandler("/files/**").addResourceLocations("file:/");
		registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/");
		WebMvcConfigurer.super.addResourceHandlers(registry);
	}

	@Bean
	ApplicationRunner init() {
		return (args) -> {
			System.out.println("I am being called from init...");
		};
	}
}
