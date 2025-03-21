package org.example.expert.domain.todo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * TodoSearchCondition : 일정 검색 요청 DTO
 * 필드명 : 제목, 생성일 이후, 생성일 이전, 관리자 닉네임
 */
@Getter
@AllArgsConstructor
public class TodoSearchCondition {

    private String title;
    private LocalDateTime createdAtGoe;
    private LocalDateTime createdAtLoe;
    private String managerNickname;
}
