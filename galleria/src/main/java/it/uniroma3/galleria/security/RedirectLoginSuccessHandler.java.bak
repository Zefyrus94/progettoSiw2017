package it.uniroma3.spring.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

@Service
public class RedirectLoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		RedirectStrategy redirectStrategy = new DefaultRedirectStrategy(); 
		System.out.println(authentication.toString());
//		redirectStrategy.sendRedirect(request, response, "/utente/" + authentication.getName());
		redirectStrategy.sendRedirect(request, response, "/");
	}

}
