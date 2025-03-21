package org.example.expert.domain.common.exception;

/**
 * InvalidRequestException : 잘못된 요청 발생 시 예외 클래스
 */
public class InvalidRequestException extends RuntimeException {
    public InvalidRequestException(String message) {
        super(message);
    }
}
