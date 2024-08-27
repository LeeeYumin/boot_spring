package com.example.sbb2.question;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class QuestionController {
	
	private final QuestionRepo questionRepo;
	
	//@Autowired
	//private QuestionRepo questionRepo;
	
	@GetMapping("/question/list") // 주소창에 들어오면
	//@ResponseBody // 이거 있으면 html 없어도 화면 보임. return 하는 거 보여줘라~
	public String list(Model model) {
		List<Question> questionList = this.questionRepo.findAll();
		//questionRepo의 객체가 필요해. 다 all 조회해서 가져올거임 -> Autowired
		
		model.addAttribute("questionList", questionList);
		// 데이터 가져올때는 model 로 가져온다. 데이터 덩어리는 "questionList" (앞에 적은거) 이걸로 쏨
		return "question_list"; //가지고 화면(뷰)에 출력하자
	}

}
