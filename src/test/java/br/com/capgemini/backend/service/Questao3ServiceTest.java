package br.com.capgemini.backend.service;

import br.com.capgemini.backend.exception.NaoEstringException;
import br.com.capgemini.backend.exception.SenhaErradoException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class Questao3ServiceTest {

    @Autowired
    private Questao3Service questao3Service;

    @Test
    void whenVerificaSeStringCalledThenSucess(){
        Assert.isTrue(questao3Service.verificaSeString("ifaafiyyy"));
    }

    @Test
    void whenAnagramasCalledThenExceptionLaunched(){
        assertThrows(NaoEstringException.class, () -> questao3Service.anagramas(" 333dd"));
    }

}
