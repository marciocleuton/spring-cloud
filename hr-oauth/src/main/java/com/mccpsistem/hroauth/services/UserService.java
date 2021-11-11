package com.mccpsistem.hroauth.services;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mccpsistem.hroauth.entities.User;
import com.mccpsistem.hroauth.feigclients.UserFeigClients;


@Service
public class UserService implements UserDetailsService{

	
	@Autowired
	private UserFeigClients userFeigClient;
	

	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	public User findByEmail(String email) {
		User user = userFeigClient.findByEmail(email).getBody();
		if (user == null) {
			logger.error("Email not found: " + email);
			throw new IllegalArgumentException("Email not found");
		}
		logger.info("Email found: " + email);
		return user;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userFeigClient.findByEmail(username).getBody();
		if (user == null) {
			logger.error("Email not found: " + username);
			throw new UsernameNotFoundException("Email not found");
		}
		logger.info("Email found: " + username);
		return user;
		
	}
}
