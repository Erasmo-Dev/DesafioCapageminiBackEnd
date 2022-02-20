package br.com.capgemini.backend.service;

import br.com.capgemini.backend.exception.NaoEstringException;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class Questao3Service {


    public List<String> anagramas(String n) throws NaoEstringException {
        if(!verificaSeString(n)){
            throw new NaoEstringException();
        }
        return anagramasCalculo(n.replaceAll(" ",""));
    }

    public boolean verificaSeString(String n) throws NaoEstringException {

        boolean texto = true;

        for (int i = 0; i < n.length(); i++) {
            char c = n.charAt(i);
            if (!Character.isAlphabetic(c)) {
                texto = false;
                throw new NaoEstringException();
            }
        }
        return texto;
    }

    public List<String> anagramasCalculo(String texto){
        List<String> retorno = new ArrayList<>();

        String primeiroPar ="", segundoPar = "";
        String primeiroParOrdenado = null, segundoParOrdenado = null;
        StringBuilder textoDuplas = new StringBuilder(texto);

        char atual = '\0';
        int j = texto.length();
        int quantidadeAnagramas = 0;

        for(int i = 0; i < textoDuplas.length(); i++){
            atual = textoDuplas.charAt(i);
            for(int g = 0; g < textoDuplas.length(); g++){
                if(g != i){
                    if(atual == textoDuplas.charAt(g)){
                        retorno.add("["+atual + " " + textoDuplas.charAt(g)+"]");
                        textoDuplas.deleteCharAt(i);
                        quantidadeAnagramas++;
                    }
                }else{
                    g++;
                }
            }
        }
        int jj = 2;

        for(int l = 0; l < (texto.length() - 2); l ++){
            for(int t = 0; t < jj; t++){
                primeiroPar += texto.charAt(t);
                segundoPar += texto.charAt(t + 1);
                char[] ordernar1 = primeiroPar.toCharArray();
                char[] ordernar2 = segundoPar.toCharArray();
                Arrays.sort(ordernar1);
                Arrays.sort(ordernar2);
                primeiroParOrdenado = new String(ordernar1);
                segundoParOrdenado = new String(ordernar2);
            }

            jj++;

            if(primeiroParOrdenado.equals(segundoParOrdenado)){
                quantidadeAnagramas++;
                retorno.add("["+primeiroPar + " " + segundoPar+"]");
            }
            primeiroPar = "";
            segundoPar = "";
        }

        retorno.add(String.valueOf(quantidadeAnagramas));

        return retorno.stream().collect(Collectors.toList());
    }


}
