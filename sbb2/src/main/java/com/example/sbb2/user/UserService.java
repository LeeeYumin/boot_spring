package com.example.sbb2.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

	public final UserRepo userRepo;
	private final PasswordEncoder passwordEncoder;

	public SiteUser create(String username, String email, String password) {
		// 사용자가 암호를 쓰겠음
		SiteUser user = new SiteUser();
		user.setUsername(username);
		user.setEmail(email);

		// 비밀번호는 그냥 안넣고 암호화해서 넣어야만 한다. 암호화한 값을 비교한다..
		// BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		user.setPassword(passwordEncoder.encode(password));

		// 암호화 한 정보를 DB에 저장
		this.userRepo.save(user);
		return user;
	}
}
