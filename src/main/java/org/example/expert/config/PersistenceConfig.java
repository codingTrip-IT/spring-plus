package org.example.expert.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * PersistenceConfig : JPA Auditing 기능을 사용하는 설정 클래스
 */
@Configuration
@EnableJpaAuditing
public class PersistenceConfig {
}
