package com.clss.activeusers.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.clss.activeusers.entity.ActiveUser;
import com.clss.activeusers.repository.ActiveUserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ActiveUserService {

	private final ActiveUserRepository repo;

	public void createOrUpdateSession(String sessionId, String username) {

		ActiveUser user = repo.findBySessionId(sessionId).orElse(new ActiveUser());

		user.setSessionId(sessionId);
		user.setUsername(username);

		if (user.getLoginTime() == null) {
			user.setLoginTime(LocalDateTime.now());
		}

		user.setLastAccessTime(LocalDateTime.now());
		user.setStatus("ACTIVE");

		repo.save(user);
	}

	public void destroySession(String sessionId) {

		repo.findBySessionId(sessionId).ifPresent(user -> {
			user.setStatus("INACTIVE");
			user.setLastAccessTime(LocalDateTime.now());
			repo.save(user);
		});
	}

	public List<ActiveUser> getActiveUsers() {
		return repo.findByStatus("ACTIVE");
	}
}