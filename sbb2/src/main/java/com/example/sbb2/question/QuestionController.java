package com.example.sbb2.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {

	private final QuestionService questionService;

	// @Autowired
	// private QuestionRepo questionRepo;

	@GetMapping("/list") // 주소창에 들어오면
	// @ResponseBody // 이거 있으면 html 없어도 화면 보임. return 하는 거 보여줘라~
	public String list(Model model) {
		List<Question> questionList = this.questionService.getList();
		// questionRepo의 객체가 필요해. 다 조회해서 가져올거임 findAll -> Autowired

		model.addAttribute("questionList", questionList);
		// 데이터 가져올때는 model 로 가져온다. 데이터 덩어리는 "questionList" (앞에 적은거) 이걸로 쏨
		return "question_list"; // 가지고 화면(뷰)에 출력하자
	}
	
	//상세페이지 read detail 조회하기
	@GetMapping("/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		// PathVariable 로 id 값을 뽑는다
		
		Question question = this.questionService.getQuestion(id);
		model.addAttribute("question", question);
		return "question_detail";

	}
}
