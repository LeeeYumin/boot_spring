package com.example.boardreply;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Board {
	
	@Id //시작값 id 넣어주기
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
    @Column(length = 100)
    private String title;

    @Column(columnDefinition = "TEXT") //썸머노트
    private String content;
	
	private LocalDateTime date;
	
	@OneToMany(mappedBy = "board", cascade = CascadeType.REMOVE)
	private List<Reply> replyList;

}