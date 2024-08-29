package com.example.sbb2.user;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.sbb2.DataNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

	public final UserRepo userRepo;
	private final PasswordEncoder passwordEncoder;

	// 유저 등록
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
	
	//현재 접속자 정보 조회
	public SiteUser getUser(String username) {
        Optional<SiteUser> siteUser = this.userRepo.findByusername(username);
        if (siteUser.isPresent()) {
            return siteUser.get(); // DB에 존재할 경우만 그 사람의 객체를 가지고 간다
        } else {
            throw new DataNotFoundException("siteuser not found");
        }
    }
}
