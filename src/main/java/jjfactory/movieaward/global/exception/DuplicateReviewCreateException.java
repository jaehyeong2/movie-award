package jjfactory.movieaward.global.exception;

public class DuplicateReviewCreateException extends RuntimeException{
    public DuplicateReviewCreateException() {
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

    public DuplicateReviewCreateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
