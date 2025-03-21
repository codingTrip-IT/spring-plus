package org.example.expert.domain.manager.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * ManagerSaveRequest : 관리자 생성 요청 DTO
 * 필드명 : 관리자 아이디
 * */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ManagerSaveRequest {

    @NotNull
    private Long managerUserId; // 일정 작상자가 배치하는 유저 id
}
