package br.com.capgemini.backend.controller;

import br.com.capgemini.backend.exception.SenhaErradoException;
import br.com.capgemini.backend.service.Questao1Service;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questao1")
@AllArgsConstructor()
public class Questao1Controller {

    private final Questao1Service questao1Service;

    @PostMapping("/{quantidade}")
    @ResponseStatus(HttpStatus.CREATED)
    public List<String> enviar(@PathVariable int quantidade) throws SenhaErradoException {
        return questao1Service.construir(quantidade);
    }

}
