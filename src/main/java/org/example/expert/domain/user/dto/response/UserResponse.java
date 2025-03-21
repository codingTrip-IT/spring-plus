package org.example.expert.domain.user.dto.response;

import lombok.Getter;

/**
 * UserResponse : 사용자 응답 DTO
 * 필드명 : 아이디, 이메일
 */
@Getter
public class UserResponse {

    private final Long id;
    private final String email;

    public UserResponse(Long id, String email) {
        this.id = id;
        this.email = email;
    }
}
