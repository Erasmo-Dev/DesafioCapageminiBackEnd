package br.com.capgemini.backend.service;

import br.com.capgemini.backend.exception.SenhaErradoException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class Questao2ServiceTest {

    @Autowired
    private Questao2Service questao2Service;

    @Test
    void whenVerificaSenhaCalledThenChecarSenhaSucess(){
        Assert.isTrue(questao2Service.verificaSenha("@Eeee3323"));
    }

    @Test
    void whenChecarSenhaCalledThenExceptionLaunched(){
        assertThrows(SenhaErradoException.class, () -> questao2Service.checarSenha("343r"));
    }

}
