package com.housseine.springsecurityjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.housseine.springsecurityjwt.models.AuthenticationRequest;
import com.housseine.springsecurityjwt.models.AuthenticationResponse;
import com.housseine.springsecurityjwt.services.MyUserDetailsService;
import com.housseine.springsecurityjwt.utils.JwtUtils;

@RestController
public class AuthenticationController {
	
//	@Autowired
//	private AuthenticationManager authenticationManager;
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	@Autowired
	private JwtUtils jwtUtils;
	
	
//	@GetMapping("/authenticate")
//	public String greetingForm(Model model) {
//		model.addAttribute("authenticationRequest",new AuthenticationRequest());	
//
//		return "authentication";
//	}
	
	@GetMapping(value = "/authenticate")
	public ResponseEntity<AuthenticationResponse> createAuthenticationToken(
			) throws Exception {

//		try {
//			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
//		} catch (BadCredentialsException e) {
//			throw new Exception("Incorrect username or password", e);
//		}

		final UserDetails userDetails = myUserDetailsService.loadUserByUsername("foo");
		final String jwt = jwtUtils.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
}
