package br.com.capgemini.backend.service;


import br.com.capgemini.backend.exception.ValorPrecisaSerInteiroMaiorQueZeroException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class Questao1ServiceTest {

    @Autowired
    private Questao1Service questao1Service;

    @Test
    void whenConstruirCalledThenEscadaConstruida(){
        Assert.notEmpty(questao1Service.construir(11));
    }

    @Test
    void whenConstruirReceivesNegativeValueThenExceptionLaunched(){
        assertThrows(ValorPrecisaSerInteiroMaiorQueZeroException.class, () -> questao1Service.construir(-11));
    }

}
