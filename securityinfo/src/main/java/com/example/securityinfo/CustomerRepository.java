package com.example.securityinfo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	//스프링 시큐리티용 로그인 처리
	Optional<Customer> findByusername(String username);

}