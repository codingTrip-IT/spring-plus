package org.example.expert.domain.todo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class TodoSearchCondition {

    private String title;
    private LocalDateTime createdAtGoe;
    private LocalDateTime createdAtLoe;
    private String managerNickname;
}
