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

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GenerateUsersTest {

    @Autowired
    private UserJdbcRepository userJdbcRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    void 유저_100만건_생성() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            UserRole userRole = i % 2 == 0 ? UserRole.ROLE_USER : UserRole.ROLE_ADMIN;
            users.add(new User("email" + i, "password" + i, userRole, "nickname" + i));

            if (i % 1_000 == 0 && i > 0) {
                userJdbcRepository.saveAllUsers(users);
                users.clear();
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