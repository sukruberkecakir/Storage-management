package com.deneme.demo.Entity

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class CustomUserDetails implements UserDetails{
	private User user
	
	CustomUserDetails(User user) {
		this.user = user
	}
	

	@Override
	Collection<? extends GrantedAuthority> getAuthorities() {
		Set<Role> roles = user.getRoles();
		List<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>()
		
		for(Role role : roles) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()))
		}
		return grantedAuthorities
	}

	@Override
	String getPassword() {
		return user.getPassword()
	}

	@Override
	String getUsername() {
		return user.getUserName()
	}

	@Override
	boolean isAccountNonExpired() {
		return true
	}

	@Override
	boolean isAccountNonLocked() {
		return true
	}

	@Override
	boolean isCredentialsNonExpired() {
		return true
	}

	@Override
	boolean isEnabled() {
		return true
	}
	
	String getFullName() {
		return user.getFirstName() + " " + user.getLastName()
	}
	
	String getEmail() {
		return user.getEmail()
	}
	
}
