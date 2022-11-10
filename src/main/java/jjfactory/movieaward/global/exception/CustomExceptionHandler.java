package jjfactory.movieaward.global.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Slf4j
@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(DuplicateReviewCreateException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorResponse duplicateException(Exception e){
        log.info("duplicate exception called");
        return new ErrorResponse("403",e.getMessage());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse entityNotFound(Exception e){
        log.info("no such element exception called");
        return new ErrorResponse("500",e.getMessage());
    }
}
