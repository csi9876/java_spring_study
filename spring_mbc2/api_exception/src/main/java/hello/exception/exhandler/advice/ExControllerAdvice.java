package hello.exception.exhandler.advice;


import hello.exception.exception.UserException;
import hello.exception.exhandler.ErrorResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice(basePackages = "package hello.exception.api") // 여기 다 적용
public class ExControllerAdvice {
    @ResponseStatus(HttpStatus.BAD_REQUEST)     // 이 처리 안하면 정상 로직으로 작동해서 200
    @ExceptionHandler(IllegalArgumentException.class)   // IllegalArgumentException 와 하위 오류 발생하면 여기서 처리 > 정상 로직
    public ErrorResult illegalExHandle(IllegalArgumentException e) {
        log.error("[exceptionHandle] ex", e);

        return new ErrorResult("BAD", e.getMessage());
    }


    @ExceptionHandler   // user-ex 오류
    public ResponseEntity<ErrorResult> userExHandle(UserException e) {
        log.error("[exceptionHandle] ex", e);

        ErrorResult errorResult = new ErrorResult("USER-EX", e.getMessage());

        return new ResponseEntity<>(errorResult, HttpStatus.BAD_REQUEST); }


    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler   // 정의되지 않은 나머지 오류들 다 여기서 잡음 (모든 익셉션)
    public ErrorResult exHandle(Exception e) {
        log.error("[exceptionHandle] ex", e);

        return new ErrorResult("EX", "내부 오류");
    }
}
