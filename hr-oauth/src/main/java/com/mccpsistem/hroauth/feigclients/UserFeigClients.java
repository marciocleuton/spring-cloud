package com.mccpsistem.hroauth.feigclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mccpsistem.hroauth.entities.User;



@Component
@FeignClient(name="hr-user", path="/user")
public interface UserFeigClients {
	
	
	@GetMapping(value= "/buscar")
	ResponseEntity<User> findByEmail(@RequestParam String email);
		

}
