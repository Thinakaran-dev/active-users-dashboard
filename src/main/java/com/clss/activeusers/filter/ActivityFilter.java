package com.clss.activeusers.filter;

import java.io.IOException;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.clss.activeusers.service.ActiveUserService;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ActivityFilter implements Filter {

	private final ActiveUserService service;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (auth != null && auth.isAuthenticated() && !(auth instanceof AnonymousAuthenticationToken)
				&& !uri.contains("/active-users") && !uri.contains("/active-count")) {

			String username = auth.getName();
			service.createOrUpdateSession(req.getSession().getId(), username);
		}

		chain.doFilter(request, response);
	}
}
