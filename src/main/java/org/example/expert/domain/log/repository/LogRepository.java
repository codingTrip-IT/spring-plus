package org.example.expert.domain.log.repository;

import org.example.expert.domain.log.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * LogRepository : 로그 리포지토리
 */
public interface LogRepository extends JpaRepository<Log, Long> {
}
