package com.example.boardreply;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyService {

	@Autowired
	private BoardService boardService;

	@Autowired
	private ReplyRepo replyRepo;

	public void create(Integer id, Reply reply) {
		Board board = boardService.readdetail(id); // id 로 Board 객체를 뽑아오자

		// reply 객체에 넣어주자
		reply.setBoard(board);
		reply.setDate(LocalDateTime.now());

		// DB 에 던지려면 이제 인터페이스(리포지터리) 만들고 Autowired 해주기
		replyRepo.save(reply);
	}

}
