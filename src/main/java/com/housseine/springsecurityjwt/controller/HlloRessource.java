package com.housseine.springsecurityjwt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HlloRessource {



	@RequestMapping({ "/hello" })
	public String hello() {
		return "hello";
	}


}
