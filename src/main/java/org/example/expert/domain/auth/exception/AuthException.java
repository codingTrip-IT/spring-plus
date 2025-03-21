package org.example.expert.domain.auth.exception;

/**
 * AuthException : 인증 과정에 예외 처리 클래스
 */
public class AuthException extends RuntimeException {

    public AuthException(String message) {
        super(message);
    }
}
