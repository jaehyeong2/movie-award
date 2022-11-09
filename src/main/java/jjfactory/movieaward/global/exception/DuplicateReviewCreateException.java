package jjfactory.movieaward.global.exception;

import lombok.Getter;

@Getter
public class DuplicateReviewCreateException extends RuntimeException{
    private static final String MESSAGE = "영화 1개당 리뷰를 하나만 작성할 수 있습니다.";

    public DuplicateReviewCreateException() {
        super(MESSAGE);
    }
    public DuplicateReviewCreateException(String message) {
        super(message);
    }

    public DuplicateReviewCreateException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateReviewCreateException(Throwable cause) {
        super(cause);
    }

}
