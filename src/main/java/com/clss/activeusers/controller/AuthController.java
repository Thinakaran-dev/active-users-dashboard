package com.clss.activeusers.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.clss.activeusers.entity.AppUser;
import com.clss.activeusers.repository.UserRepository;
import com.clss.activeusers.service.ActiveUserService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AuthController {

	private final UserRepository userRepository;
	private final ActiveUserService activeUserService;
	private final PasswordEncoder passwordEncoder;

	@GetMapping("/login")
	public String login() {
		return "login"; // refers to login.html in templates
	}

	@GetMapping("/signup")
	public String signupPage() {
		return "signup";
	}

	@PostMapping("/signup")
	public String signup(@RequestParam String username, @RequestParam String password,
			@RequestParam(defaultValue = "USER") String role, Model model) {

		if (userRepository.findByUsername(username).isPresent()) {
			model.addAttribute("error", "Username already exists");
			return "signup";
		}

		AppUser user = new AppUser();
		user.setUsername(username);
		user.setPassword(passwordEncoder.encode(password));
		user.setRole(role); // USER or ADMIN

		userRepository.save(user);

		return "redirect:/login";
	}

	@GetMapping("/dashboard")
	public String dashboard(Authentication auth, HttpSession session, Model model) {
		String username = auth.getName();
		model.addAttribute("username", username);

		activeUserService.createOrUpdateSession(session.getId(), username);
		return "dashboard";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')") // ✅ extra protection
	public String admin(Authentication authentication, Model model) {
		model.addAttribute("username", authentication.getName());
		return "admin";
	}
}