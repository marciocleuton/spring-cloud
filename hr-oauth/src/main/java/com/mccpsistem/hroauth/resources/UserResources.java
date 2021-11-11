package com.mccpsistem.hroauth.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mccpsistem.hroauth.entities.User;
import com.mccpsistem.hroauth.services.UserService;

@RestController
@RefreshScope
@RequestMapping(value ="/user")
public class UserResources {

	@Autowired
	 private UserService userService;    
	
	@GetMapping(value= "/buscar")
	public ResponseEntity<User> findByEmail(@RequestParam String email){
		
		User obj = userService.findByEmail(email);
		return ResponseEntity.ok(obj);
	}
}
