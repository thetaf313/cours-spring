package cours.udb.j2e.coursspring.exception;

import cours.udb.j2e.coursspring.dto.ErrorDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.xml.ResourceEntityResolver;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    @ExceptionHandler(value = { Exception.class })
    public ErrorDTO handleException(Exception exception) {

        log.error(exception.getMessage(), exception);
        return ErrorDTO.builder()
                .code(HttpStatus.BAD_REQUEST.value() + "")
                .message(exception.getMessage())
                .build();
    }

    @ExceptionHandler(value = { NoHandlerFoundException.class })
    public ResponseEntity<ErrorDTO> handleNotFoundException (NoHandlerFoundException exception) {

        ErrorDTO response = new ErrorDTO("404", "Ressource Introuvable");
        log.error(exception.getMessage(), exception);

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }
}
