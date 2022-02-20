package br.com.capgemini.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NaoEstringException extends RuntimeException{

    public NaoEstringException() {
        super("O valor informado não é um texto valido!");
    }
}
