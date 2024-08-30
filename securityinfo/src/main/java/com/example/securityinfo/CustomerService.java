package com.example.securityinfo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements UserDetailsService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	// 스프링 시큐리티 로그인처리 인터페이스 구현
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Customer> _customer = customerRepository.findByusername(username);
		
		if (_customer.isEmpty()) {
			throw new UsernameNotFoundException("You need to Sign up first...");
		}
		Customer customer = _customer.get();
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		if ("ROLE_USER".equals(customer.getRole())) {//일반 회궝의 경우
			authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		}else if ("ROLE_MANAGER".equals(customer.getRole())) {//일반 회궝의 경우
			authorities.add(new SimpleGrantedAuthority("ROLE_MANAGER"));
		}else {
			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		}
		return new User(customer.getUsername(), customer.getPassword(), authorities);
	}

	// 회원가입
	 public void create(Customer customer) {
		 customer.setEnabled(true);
		 customer.setRole("ROLE_USER"); //회원 가입시 일반회원 즉 ROLE_USER 권한을 넣어준다.
		 customer.setCdate(LocalDateTime.now());
		 customer.setPassword(passwordEncoder.encode(customer.getPassword()));
		 customerRepository.save(customer);
	 }
	
	
	// CRUD
	
	
}
