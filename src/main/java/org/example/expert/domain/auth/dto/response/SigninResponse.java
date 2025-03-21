package org.example.expert.domain.auth.dto.response;

import lombok.Getter;

/**
 * SigninResponse : 로그인 응답 DTO
 * 필드명 : 토큰
 * */
@Getter
public class SigninResponse {

    private final String bearerToken;

    public SigninResponse(String bearerToken) {
        this.bearerToken = bearerToken;
    }
}
