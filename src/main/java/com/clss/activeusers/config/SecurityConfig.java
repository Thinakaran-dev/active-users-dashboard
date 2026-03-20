package com.clss.activeusers.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.clss.activeusers.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	private final UserRepository userRepository;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		return username -> userRepository.findByUsername(username)
				.map(user -> User.builder().username(user.getUsername()).password(user.getPassword())
						.roles(user.getRole()).build())
				.orElseThrow(() -> new UsernameNotFoundException("User not found"));
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth -> auth.requestMatchers("/login", "/signup", "/css/**", "/js/**").permitAll()
				.requestMatchers("/admin").hasRole("ADMIN").anyRequest().authenticated())
				.formLogin(form -> form.loginPage("/login").defaultSuccessUrl("/dashboard", true))
				.logout(logout -> logout.permitAll()).exceptionHandling(ex -> ex.accessDeniedPage("/access-denied") // ✅
																													// redirect
																													// on
																													// 403
				);

		return http.build();
	}
}