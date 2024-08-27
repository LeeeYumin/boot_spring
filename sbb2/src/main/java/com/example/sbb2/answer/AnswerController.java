package com.example.sbb2.answer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sbb2.question.Question;
import com.example.sbb2.question.QuestionService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {

	private final QuestionService questionService; // 객체 생성
	private final AnswerService answerService; // answer 객체 생성 

	@PostMapping("/create/{id}") // 넘겨받는 주소
	public String createAnswer(Model model, @PathVariable("id") Integer id, @RequestParam("content") String content) {
		Question question = this.questionService.getQuestion(id);
		answerService.create(question, content); // 이거까지 넣어야 DB에 들어감
		return "redirect:/question/detail/" + id;
	}
}
