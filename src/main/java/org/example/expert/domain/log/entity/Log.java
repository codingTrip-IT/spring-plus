package org.example.expert.domain.log.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * Log : 로그 엔티티
 */
@Entity
@Table(name = "logs")
@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Log{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private Long todoId;

    @CreatedDate
    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    public Log(String email, Long todoId) {
        this.email = email;
        this.todoId = todoId;
    }
}
