package com.clss.activeusers.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "active_users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActiveUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String sessionId;
	private String username;
	private LocalDateTime loginTime;
	private LocalDateTime lastAccessTime;
	private String status;
}
