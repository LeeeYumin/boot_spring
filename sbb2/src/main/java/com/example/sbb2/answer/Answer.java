package com.example.sbb2.answer;

import java.time.LocalDateTime;

import com.example.sbb2.question.Question;
import com.example.sbb2.user.SiteUser;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Answer {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate; 
    
    private LocalDateTime modifyDate;
    
    @ManyToOne
    private Question question;
    
    @ManyToOne
    private SiteUser author;
}
