package org.example.expert.domain.user;

import org.example.expert.domain.user.entity.User;
import org.example.expert.domain.user.enums.UserRole;
import org.example.expert.domain.user.repository.UserJdbcRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * GenerateUsers : 테스트를 위한 user생성 클래스
 */
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GenerateUsers {

    @Autowired
    private UserJdbcRepository userJdbcRepository;

    private static final int USER_INSERT_COUNT = 1_000_000;
    private static final int BATCH_SIZE = 1_000;

    @Test
    @Transactional
    @Rollback(value = false)
    void 유저_100만건_생성() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < USER_INSERT_COUNT; i++) {
            UserRole userRole = i % 2 == 0 ? UserRole.ROLE_USER : UserRole.ROLE_ADMIN;
            users.add(new User("email" + i + "@naver.com", "Password" + i, userRole, "nickname" + i));

            if (i % BATCH_SIZE == 0 && i > 0) {
                userJdbcRepository.saveAllUsers(users);
                users.clear();
                /* 배치 사이즈마다 0.5초씩 sleep 처리 */
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        if (!users.isEmpty()) {
            userJdbcRepository.saveAllUsers(users);
        }
    }
}