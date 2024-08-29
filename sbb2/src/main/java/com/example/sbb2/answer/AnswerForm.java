package com.example.sbb2.answer;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class AnswerForm {
	@NotEmpty(message = "내용은 필수항목")
	private String content;
	
}
