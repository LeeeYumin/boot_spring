package com.example.securitytest;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Employee {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String empname;

    private String password;
    
    @Column
    private String dept;
    
    @Column(columnDefinition = "TEXT")
    private String intro;
    
    private LocalDateTime inDate;
    
    @Column(unique = true)
    private String email;
	
}
