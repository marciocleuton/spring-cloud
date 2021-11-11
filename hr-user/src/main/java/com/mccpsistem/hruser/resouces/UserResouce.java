package com.mccpsistem.hruser.resouces;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mccpsistem.hruser.entities.User;
import com.mccpsistem.hruser.repositories.UserRepository;



@RestController
@RefreshScope
@RequestMapping(value ="/user")

public class UserResouce {
	
	@Autowired
	 private UserRepository userRepository;      
	
	@GetMapping(value= "/{id}")
	public ResponseEntity<User> findByid(@PathVariable Long id){
		
		User obj = userRepository.findById(id).get();
		return ResponseEntity.ok(obj);
	}
	
	@GetMapping(value= "/buscar")
	public ResponseEntity<User> findByEmail(@RequestParam String email){
		
		User obj = userRepository.findByEmail(email);
		return ResponseEntity.ok(obj);
	}


}
