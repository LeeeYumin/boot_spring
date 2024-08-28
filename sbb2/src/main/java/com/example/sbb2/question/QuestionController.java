package com.example.sbb2.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.validation.Valid;
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
	
	//질문등록하기 버튼
    @GetMapping("/create")
    public String questionCreate(QuestionForm questionForm) {
        return "question_form";
    }
    
    //질문 입력한 내용 받아주기 + 검증
    @PostMapping("/create")
    public String questionCreate(@Valid QuestionForm questionForm, // 겁토는 validation 이용함
    							BindingResult bindingResult) { //검증 결과를 받아줌
    		
    							//@RequestParam(value="subject") String subject,
    							//@RequestParam(value="content") String content) {
    	
    	if(bindingResult.hasErrors()) {
    		return "question_form";
    	}
    	this.questionService.create(questionForm.getSubject(), questionForm.getContent()); //입력받은 값들을 서비스로
    	return "redirect:/question/list";
    }
    
    
}
