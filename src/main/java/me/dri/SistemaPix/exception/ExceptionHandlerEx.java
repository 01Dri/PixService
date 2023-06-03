package me.dri.SistemaPix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ExceptionHandlerEx {

    @ExceptionHandler(NotLimitException.class)
    public ResponseEntity<ExceptionEntity> resourceNotFound(NotLimitException e)  {
        String error = "Erro na operação";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ExceptionEntity err = new ExceptionEntity(new Date(),  error, e.getMessage(), status.value());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(KeyPixInvalid.class)
    public ResponseEntity<ExceptionEntity> resourceNotFound(KeyPixInvalid e)  {
        String error = "Erro na transação";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ExceptionEntity err = new ExceptionEntity(new Date(),  error, e.getMessage(), status.value());
        return ResponseEntity.status(status).body(err);
    }
}
