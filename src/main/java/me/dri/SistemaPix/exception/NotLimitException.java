package me.dri.SistemaPix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotLimitException extends RuntimeException {

    public NotLimitException(String msg) {
        super(msg);
    }
    
}
