package br.com.capgemini.backend.controller;
import br.com.capgemini.backend.exception.NaoEstringException;
import br.com.capgemini.backend.service.Questao3Service;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/questao3")
@AllArgsConstructor()
public class Questao3Controller {

    private final Questao3Service questao3Service;

    @PostMapping("/{texto}")
    @ResponseStatus(HttpStatus.CREATED)
    public List<String> enviar(@PathVariable String texto) throws NaoEstringException {
        return questao3Service.anagramas(texto);
    }

}
