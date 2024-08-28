package com.example.securityexam;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cid;

	// 시큐리티 규격에 맞게 항상 4개는 똑같이 넣어준다
	private String username; // 회원 아이디, 이메일 주소로 하면 많이 편하다.
	private String password;
	private boolean enabled;
	private String role;

	// 위 4개는 항상 동일한 이름으로 넣어주고(c 안붙임) 아래는 선택사항
	private String cimage;
	private String caddr;

	private LocalDateTime cdate;

}
