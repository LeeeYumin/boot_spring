package com.example.boardreply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	//들어가자마자 readlist 뜨게
	@GetMapping("/")
	public String index() {
		return "redirect:/readlist";
	}

	// 목록 조회
	@GetMapping("/readlist") // 주소로 호출
	public String readlist(Model model) {
		model.addAttribute("boards", boardService.readlist());
		return "readlist";
	}

	// 단건 조회
	@GetMapping("/readdetail/{id}") // id 값으로 조회할거니까
	public String readdetail(Model model, @PathVariable("id") Integer id) {
		model.addAttribute("board", boardService.readdetail(id));
		return "readdetail";
	}
	
}
