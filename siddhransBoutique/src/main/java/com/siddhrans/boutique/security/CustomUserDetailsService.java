package com.siddhrans.boutique.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.siddhrans.biometric.model.User;
import com.siddhrans.biometric.model.UserProfile;
import com.siddhrans.boutique.model.CustomerDetails;
import com.siddhrans.boutique.model.Employee;
import com.siddhrans.boutique.service.CustomerDetailsService;
import com.siddhrans.boutique.service.RegistrationService;

public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	CustomerDetailsService customerDetailsService;
	
	@Autowired
	RegistrationService registrationService;
	

	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		User user = userService.findByUserName(userName);
		logger.info("User : {}", user);
		if(user==null){
			logger.info("User not found");
			throw new UsernameNotFoundException("Username not found");
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), 
				true, true, true, true, getGrantedAuthorities(user));
	}


	private List<GrantedAuthority> getGrantedAuthorities(User user){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		UserProfile userProfile = user.getUserProfile();
		logger.info("UserProfile : {}", userProfile);
		authorities.add(new SimpleGrantedAuthority("ROLE_"+userProfile.getType()));
		logger.info("authorities : {}", authorities);
		return authorities;
	}
}
