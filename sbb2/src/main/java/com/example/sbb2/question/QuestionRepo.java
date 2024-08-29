package com.example.sbb2.question;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepo extends JpaRepository<Question, Integer> {
	
	Question findBySubject(String subject); //JUnit findBySubject
	
	//JUnit findBySubjectAndContent 메서드 테스트
	Question findBySubjectAndContent(String subject, String content); 
	
	//게시물이 많아질 경우 페이징기능
	Page<Question> findAll(Pageable pageable);
	
	

}
