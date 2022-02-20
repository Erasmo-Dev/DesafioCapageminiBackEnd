package br.com.capgemini.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SenhaErradoException extends RuntimeException{

    public SenhaErradoException() {
        super("A senha precisa ter no minimo caracteres, 1 letra maiuscula, 1 minuscula, 1 caractere especial, 1 digito");
    }

}
