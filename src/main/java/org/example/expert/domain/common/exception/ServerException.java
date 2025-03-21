package org.example.expert.domain.common.exception;

/**
 * ServerException : 서버 예외 클래스
 */
public class ServerException extends RuntimeException {

    public ServerException(String message) {
        super(message);
    }
}
