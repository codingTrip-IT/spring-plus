package org.example.expert.domain.auth.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * SigninRequest : 로그인 요청 DTO
 * 필드명 : 이메일, 비밀번호
 * */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SigninRequest {
    
    @NotBlank @Email
    private String email;
    @NotBlank
    private String password;
}
