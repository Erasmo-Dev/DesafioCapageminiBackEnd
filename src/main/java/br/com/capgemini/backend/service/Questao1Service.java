package br.com.capgemini.backend.service;


import br.com.capgemini.backend.exception.ValorPrecisaSerInteiroMaiorQueZeroException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Questao1Service {


    public List<String> construir(int n){
        verificaValorNegativo(n);
        return escada(n);
    }

    public boolean verificaValorNegativo(int n){
        if(n < 1){
            throw new ValorPrecisaSerInteiroMaiorQueZeroException();
        }
        return true;
    };

    public List<String> escada(int n) {
        int aux = n - 1;
        String espaco = "";
        String estrela = "";
        List<String> escadinha = new ArrayList<String>();
        for (int i = 1; i <= n; i++) {

            for (int j = 0; j < aux; j++) {
                espaco += " ";
            }
            for (int g = 0; g < (n - aux); g++) {
                estrela += "*";
            }
            aux--;
            escadinha.add(espaco + estrela);
            espaco = "";
            estrela = "";
        }
        return escadinha;
    }

}
