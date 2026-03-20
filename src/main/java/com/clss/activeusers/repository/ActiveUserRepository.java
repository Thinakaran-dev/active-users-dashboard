package com.clss.activeusers.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clss.activeusers.entity.ActiveUser;

@Repository
public interface ActiveUserRepository extends JpaRepository<ActiveUser, Long> {
	Optional<ActiveUser> findBySessionId(String sessionId);

	List<ActiveUser> findByStatus(String status);
}