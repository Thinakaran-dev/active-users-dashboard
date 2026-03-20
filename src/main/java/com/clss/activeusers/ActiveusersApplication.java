package com.clss.activeusers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.clss.activeusers.listener.SessionListener;
import com.clss.activeusers.service.ActiveUserService;

import jakarta.servlet.http.HttpSessionListener;

@SpringBootApplication
@EnableScheduling
public class ActiveusersApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActiveusersApplication.class, args);
	}

	@Bean
	public ServletListenerRegistrationBean<HttpSessionListener> sessionListener(ActiveUserService service) {
		return new ServletListenerRegistrationBean<>(new SessionListener(service));
	}
}
