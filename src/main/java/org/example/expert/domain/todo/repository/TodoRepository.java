package org.example.expert.domain.todo.repository;

import org.example.expert.domain.todo.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface TodoRepository extends JpaRepository<Todo, Long>, TodoRepositoryCustom{

    @Query("SELECT t FROM Todo t LEFT JOIN FETCH t.user u " +
            "WHERE (coalesce(:weather, NULL) IS NULL OR t.weather = :weather) " +
            "AND CASE WHEN :startDate IS NOT NULL AND :endDate IS NOT NULL " +
            "THEN (t.modifiedAt >= DATE(:startDate) AND t.modifiedAt < DATE(:endDate)) " +
            "WHEN :startDate is null AND :endDate is not null " +
            "THEN (t.modifiedAt < DATE(:endDate)) " +
            "WHEN :startDate is not null AND :endDate is null " +
            "THEN (t.modifiedAt >= DATE(:startDate)) " +
            "WHEN :startDate is null AND :endDate is null " +
            "THEN (1=1) " +
            "END " +
            "ORDER BY t.modifiedAt DESC")
    Page<Todo> findAllByOrderByModifiedAtDesc(Pageable pageable, String weather, LocalDate startDate, LocalDate endDate);

   /* @Query("SELECT t FROM Todo t " +
            "LEFT JOIN t.user " +
            "WHERE t.id = :todoId")
    Optional<Todo> findByIdWithUser(@Param("todoId") Long todoId);*/
}
