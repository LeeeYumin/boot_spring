package com.example.boardreply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReplyController {

	@Autowired
	ReplyService replyService;

	@PostMapping("/reply/create/{id}")
	public String create(@PathVariable("id") Integer id, @ModelAttribute Reply reply) { // 객체 띠로 생성없이 객체로 바로 받자

		// 컨트롤러에서 서비스로 보내기
		replyService.create(id, reply);

		// 댓글달고나서 돌아오는 페이지. id 값은 돌아가기 위해 필요함
		return "redirect:/readdetail/" + id;
	}

}
