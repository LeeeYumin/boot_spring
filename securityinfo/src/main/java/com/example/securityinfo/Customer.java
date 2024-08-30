package com.example.securityinfo;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cid;
	
	// 아래 4개 항목은 시큐리티 필수 포함 항목들로 항상 넣는다. 
	@Column(unique = true)
	private String username;
	private String password;
	private boolean enabled;
	private String role;
	
	
	private LocalDateTime cdate;
}
