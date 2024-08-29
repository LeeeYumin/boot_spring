package com.example.sbb2.answer;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sbb2.question.Question;
import com.example.sbb2.question.QuestionService;
import com.example.sbb2.user.SiteUser;
import com.example.sbb2.user.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {

	private final QuestionService questionService; // 객체 생성
	private final AnswerService answerService; // answer 객체 생성 
	private final UserService userService;

	@PreAuthorize("isAuthenticated()")
	@PostMapping("/create/{id}") // 넘겨받는 주소
	public String createAnswer(Model model, @PathVariable("id") Integer id, 
			//@RequestParam("content") String content) {
			@Valid AnswerForm answerForm, BindingResult bindingResult, Principal principal) {
																		//principal 는 작성자 정보를 뽑아내는 객체
		Question question = this.questionService.getQuestion(id);
		SiteUser siteUser = this.userService.getUser(principal.getName());
		if (bindingResult.hasErrors()) {
            model.addAttribute("question", question);
            return "question_detail";
        }
		answerService.create(question, answerForm.getContent(), siteUser); // 이거까지 넣어야 DB에 들어감
		return "redirect:/question/detail/%s" + id;
	}
}
