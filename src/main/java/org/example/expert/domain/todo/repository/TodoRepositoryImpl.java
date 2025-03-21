package org.example.expert.domain.todo.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.example.expert.domain.todo.dto.request.TodoSearchCondition;
import org.example.expert.domain.todo.dto.response.QTodoSearchResponse;
import org.example.expert.domain.todo.dto.response.TodoSearchResponse;
import org.example.expert.domain.todo.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.example.expert.domain.comment.entity.QComment.comment;
import static org.example.expert.domain.manager.entity.QManager.manager;
import static org.example.expert.domain.todo.entity.QTodo.todo;
import static org.example.expert.domain.user.entity.QUser.user;
import static org.springframework.util.StringUtils.hasText;

@Repository
@RequiredArgsConstructor
public class TodoRepositoryImpl implements TodoRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    @Override
    public Optional<Todo> findByIdWithUser(Long todoId) {

        Todo result = queryFactory
                .selectFrom(todo)
                .leftJoin(todo.user, user).fetchJoin()
                .where(todo.id.eq(todoId))
                .fetchOne();

        return Optional.ofNullable(result);
    }

    @Override
    public Page<TodoSearchResponse> search(TodoSearchCondition condition, Pageable pageable) {
        List<TodoSearchResponse> content = getTodoSearchResponse(condition, pageable);
        Long total = getTotal(condition);

        return PageableExecutionUtils.getPage(content, pageable, total::longValue);
    }

    private List<TodoSearchResponse> getTodoSearchResponse(TodoSearchCondition condition, Pageable pageable) {
        List<TodoSearchResponse> content = queryFactory
                .select(new QTodoSearchResponse(
                        todo.title,
                        JPAExpressions.select(manager.count()).from(manager).where(manager.todo.eq(todo)),
                        JPAExpressions.select(comment.count()).from(comment).where(comment.todo.eq(todo))
                ))
                .from(todo)
                .where(
                        titleContains(condition.getTitle()),
                        createdAtGoe(condition.getCreatedAtGoe()),
                        createdAtLoe(condition.getCreatedAtLoe()),
                        managerNicknameContains(condition.getManagerNickname())
                )
                .orderBy(todo.createdAt.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        return content;
    }

    private Long getTotal(TodoSearchCondition condition) {
        Long total = queryFactory
                .select(todo.count())
                .from(todo)
                .where(
                        titleContains(condition.getTitle()),
                        createdAtGoe(condition.getCreatedAtGoe()),
                        createdAtLoe(condition.getCreatedAtLoe()),
                        managerNicknameContains(condition.getManagerNickname())
                )
                .fetchOne();

        return total;
    }

    private BooleanExpression titleContains(String title) {
        return hasText(title) ? todo.title.contains(title) : null;
    }

    private BooleanExpression createdAtGoe(LocalDateTime createdAtGoe) {
        return createdAtGoe != null ? todo.createdAt.goe(createdAtGoe) : null;
    }

    private BooleanExpression createdAtLoe(LocalDateTime createdAtLoe) {
        return createdAtLoe != null ? todo.createdAt.loe(createdAtLoe) : null;
    }

    private BooleanExpression managerNicknameContains(String managerNickname) {
        return hasText(managerNickname) ? manager.user.nickname.contains(managerNickname) : null;
    }
}
