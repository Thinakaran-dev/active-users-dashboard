package com.clss.activeusers.listener;

import com.clss.activeusers.service.ActiveUserService;

import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

	private final ActiveUserService service;

	public SessionListener(ActiveUserService service) {
		this.service = service;
	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("✅ Session Created: " + se.getSession().getId());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("❌ Session Destroyed: " + se.getSession().getId());
		service.destroySession(se.getSession().getId());
	}
}
