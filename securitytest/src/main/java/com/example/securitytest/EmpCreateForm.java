package com.example.securitytest;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EmpCreateForm {

	@Size(min = 3, max = 25)
    @NotEmpty(message = "사용자ID 입력은 필수입니다.")
    private String empname;

    @NotEmpty(message = "비밀번호 입력은 필수항목입니다.")
    private String password1;

    @NotEmpty(message = "비밀번호 확인은 필수입니다.")
    private String password2;
    
    @NotEmpty(message = "이메일은 필수항목입니다.")
    @Email
    private String email;

}
