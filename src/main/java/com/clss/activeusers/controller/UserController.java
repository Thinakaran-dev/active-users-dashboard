package com.clss.activeusers.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clss.activeusers.entity.ActiveUser;
import com.clss.activeusers.service.ActiveUserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {

	private final ActiveUserService service;

	@GetMapping("/active-users")
	public List<ActiveUser> activeUsers() {
		return service.getActiveUsers();
	}

	@GetMapping("/active-count")
	public int activeCount() {
		return service.getActiveUsers().size();
	}
}
