package com.mysite.sbb.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SiteUser, Long> {
	//로그인 시 입력한 username 즉 아이디가 디비에 존재하는지 옵셔널로 추출
	Optional<SiteUser> findByusername(String username);

}
