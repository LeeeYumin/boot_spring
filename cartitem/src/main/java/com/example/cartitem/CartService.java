package com.example.cartitem;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

	@Autowired // 생성자 주입
	private CartRepo cartRepo;
	
	List<Cart> readlist() {
		return cartRepo.findAll(); 
	}
	
	//read detail
	Cart readdetail(Integer id) { // 아이디 값을 가져와서 조회
		Optional<Cart> ob = cartRepo.findById(id);
		return ob.get();
	}

}
