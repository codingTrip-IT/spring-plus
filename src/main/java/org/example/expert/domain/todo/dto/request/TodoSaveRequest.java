package org.example.expert.domain.todo.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * TodoSaveRequest : 일정 생성 요청 DTO
 * 필드명 : 제목, 내용
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TodoSaveRequest {

    @NotBlank
    private String title;
    @NotBlank
    private String contents;
}
