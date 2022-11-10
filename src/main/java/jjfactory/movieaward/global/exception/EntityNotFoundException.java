package jjfactory.movieaward.global.exception;

import lombok.Getter;

@Getter
public class EntityNotFoundException extends RuntimeException{
    private static final String MESSAGE = "존재하지 않는 엔티티입니다.";

    public EntityNotFoundException() {
        super(MESSAGE);
    }
    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityNotFoundException(Throwable cause) {
        super(cause);
    }

}
