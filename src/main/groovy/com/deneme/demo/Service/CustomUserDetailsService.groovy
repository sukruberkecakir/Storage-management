package com.deneme.demo.Service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException

import com.deneme.demo.Entity.CustomUserDetails
import com.deneme.demo.Entity.User
import com.deneme.demo.Repository.UserRepository

class CustomUserDetailsService implements UserDetailsService{
	@Autowired
	private UserRepository userRepo

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByEmail(username)
		if(user == null) {
			throw new UsernameNotFoundException("User could not found!")
		}
		return new CustomUserDetails(user)
	}
	
	
}
