package org.example.expert.domain.auth.dto.response;

import lombok.Getter;

/**
 * SignupResponse : 회원가입 응답 DTO
 * 필드명 : 토큰
 * */
@Getter
public class SignupResponse {

    private final String bearerToken;

    public SignupResponse(String bearerToken) {
        this.bearerToken = bearerToken;
    }
}
