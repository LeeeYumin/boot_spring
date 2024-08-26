package com.example.sbb2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.sbb2.question.Question;
import com.example.sbb2.question.QuestionRepo;

@SpringBootTest
class Sbb2ApplicationTests {

	@Autowired
	private QuestionRepo questionRepo;
	
	
	@Test
    void testJpa() {
        Question q = this.questionRepo.findBySubjectAndContent(
                "왜 주말은 빨리 지나갈까요?", "생각해보니 2일 뿐이라서 빨리 지나갈 수 밖에 없었다...");
        assertEquals(2, q.getId());
    }
	
	
//	@Test
//	void testJpa() {
//		Question q = this.questionRepo.findBySubject("다시 테스트함1111");
//		assertEquals(4, q.getId()); // subject 값으로 조회
//	}
	
	
	
	// @Test // readdetail
	void readdetail() {
		Optional<Question> oq = this.questionRepo.findById(4);
		if(oq.isPresent()) {
			Question q = oq.get();
			assertEquals("다시 테스트함1111", q.getSubject()); //일치하는지 확인하겠음
		}
		
	}
	
	
	
	// @Test
	void readlist() {
		List<Question> all = this.questionRepo.findAll();
		assertEquals(4, all.size()); //4개인지 확인하겠음
	}
	
	
	
	// @Test @붙은거만 동작함.
//	void testJpa() { //create
//		Question q1 = new Question();
//		q1.setSubject("다시 테스트함1111");
//		q1.setContent("다시 테스트함1111");
//		q1.setCreateDate(LocalDateTime.now());
//		
//		this.questionRepo.save(q1);
//	}
}
