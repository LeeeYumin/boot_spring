package com.example.noticeexam;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeService {
	
	@Autowired // 생성자 주입
	private NoticeRepo noticeRepo;
	
	List<Notice> readlist() {
		return noticeRepo.findAll(); // read list : 전체 목록 조회
	}
	
	//read detail
	Notice readdetail(Integer id) { // 아이디 값을 가져와서 조회한다
		Optional<Notice> ob = noticeRepo.findById(id); // 없을 경우 대비. optional 은 없어도 안터지게 해줌
		return ob.get();
	}
}
