package com.swarg.profilemanagment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ProfilemanagmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfilemanagmentApplication.class, args);
	}
	
	//@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:4200", "http://127.0.0.1:8082", "http://192.168.43.63:8081");
			}
		};
	}

}
