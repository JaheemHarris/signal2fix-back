package com.projetCloud.backOffice.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.projetCloud.backOffice.models.Admin;
import com.projetCloud.backOffice.repositories.AdminRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<Admin> adminOpt = adminRepository.findByEmail(email);
		Admin admin = null;
		User user = null;
		if(adminOpt.isPresent()) {
			admin = adminOpt.get();
			user = new User(admin.getEmail(),admin.getPassword(), new ArrayList<>());
		}else {
			throw new UsernameNotFoundException(email);
		}
		return user;
	}

}
