package com.carritodecompras.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/carritodecompras")
public class LogoutPersonalizado {

	@PostMapping("/logout")
	public RedirectView logout (HttpServletRequest request, HttpSession session) {
		
		// Invalida la sesión actual
		if(session != null) {
			session.invalidate();
		}
		
		
		//// Borra la autenticación actual 
		SecurityContextHolder.clearContext();
		
		
		return new RedirectView("");
	}
}
