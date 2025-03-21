package org.example.expert.domain.user.dto.response;

import lombok.Getter;

/**
 * UserSaveResponse : 사용자 생성 응답 DTO
 * 필드명 : 토큰
 */
@Getter
public class UserSaveResponse {

    private final String bearerToken;

    public UserSaveResponse(String bearerToken) {
        this.bearerToken = bearerToken;
    }
}
