package com.example.sbb2.answer;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.sbb2.question.Question;
import com.example.sbb2.user.SiteUser;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AnswerService {
	
	private final AnswerRepo answerRepo; // 객체 생성
	
	public void create(Question question, String content, SiteUser author) {
		Answer answer = new Answer(); // 객체 생성
		answer.setContent(content);
		answer.setCreateDate(LocalDateTime.now());
		answer.setQuestion(question);
		answer.setAuthor(author);
		
		this.answerRepo.save(answer); // 만들어진 객체를 DB에 던짐
		
	}

}
