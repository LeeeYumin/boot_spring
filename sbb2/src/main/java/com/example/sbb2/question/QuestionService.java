package com.example.sbb2.question;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import groovyjarjarantlr4.v4.parse.ANTLRParser.throwsSpec_return;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService {

	private final QuestionRepo questionRepo; // 리포지터리 객체 생성

	// 호출
	public List<Question> getList() {
		return this.questionRepo.findAll();
	}

	// 상세보기
	public Question getQuestion(Integer id) {

		// 1개의 데이터를 조회할때는 반드시 Optional 로 조회한다
		// 그 이유는 데이터가 없을 경우 시스템이 다운됨
		// 그것을 방지하기 위해 Optional 로 조회하면 데이터가 없어도 다운은 안됨
		Optional<Question> question = this.questionRepo.findById(id);
		return question.get();
		
//		if (question.isPresent()) {
//			return question.get();
//		} else { // 없으면 예외발생
//			throw new DataNotFoundException("question not found");
//		}
	}
	
	//질문 작성 서비스로 넘겨받기
    public void create(String subject, String content) {
        Question q = new Question();
        q.setSubject(subject);
        q.setContent(content);
        q.setCreateDate(LocalDateTime.now());
        this.questionRepo.save(q);
    }
}
