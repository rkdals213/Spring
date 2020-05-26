package com.ssafy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.interceptor.LoggingInterceptor;
import com.ssafy.interceptor.SessionInterceptor;

@SpringBootApplication
public class ZoomDay05Application implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(ZoomDay05Application.class, args);
	}

	@Autowired
	LoggingInterceptor li;

	@Autowired
	SessionInterceptor si;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(li).addPathPatterns("/**");
		registry.addInterceptor(si).addPathPatterns("/user/**");
	}
}
