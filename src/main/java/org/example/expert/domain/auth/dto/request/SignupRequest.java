package org.example.expert.domain.auth.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * SignupRequest : 회원가입 요청 DTO
 * 필드명 : 이메일, 비밀번호, 사용자권한, 닉네임
 * */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {

    @NotBlank @Email
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String userRole;
    /* nickname 추가 */
    @NotBlank
    private String nickname;
}
