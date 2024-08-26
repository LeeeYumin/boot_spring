package com.example.sbb2.question;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepo extends JpaRepository<Question, Integer> {
	
	Question findBySubject(String subject); //JUnit findBySubject
	
	//JUnit findBySubjectAndContent 메서드 테스트
	Question findBySubjectAndContent(String subject, String content); 
	
	

}
