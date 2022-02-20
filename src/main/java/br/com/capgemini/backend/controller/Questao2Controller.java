package br.com.capgemini.backend.controller;


import br.com.capgemini.backend.exception.SenhaErradoException;
import br.com.capgemini.backend.service.Questao2Service;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/questao2")
@AllArgsConstructor()
public class Questao2Controller {

    private final Questao2Service questao2Service;

    @PostMapping("/{senha}")
    @ResponseStatus(HttpStatus.CREATED)
    public String enviar(@PathVariable String senha) throws SenhaErradoException {
        return questao2Service.checarSenha(senha);
    }

}
