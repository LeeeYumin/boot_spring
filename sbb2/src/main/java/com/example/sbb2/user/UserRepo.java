package com.example.sbb2.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<SiteUser, Long> {
	
	//로그인에 User 조회
	Optional<SiteUser> findByusername(String username);

}
