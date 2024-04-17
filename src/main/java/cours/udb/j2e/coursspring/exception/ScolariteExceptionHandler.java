package cours.udb.j2e.coursspring.exception;

import cours.udb.j2e.coursspring.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ScolariteExceptionHandler extends GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(value = { ScolariteException.class })
    public ErrorDTO handleException(ScolariteException scolariteException) {

        return ErrorDTO.builder()
                .code(HttpStatus.BAD_REQUEST + "")
                .message(scolariteException.getMessage())
                .build();
    }

}
