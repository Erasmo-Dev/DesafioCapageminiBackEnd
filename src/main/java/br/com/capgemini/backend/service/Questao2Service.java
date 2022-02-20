package br.com.capgemini.backend.service;


import br.com.capgemini.backend.exception.SenhaErradoException;
import org.springframework.stereotype.Service;

@Service
public class Questao2Service {


    public String checarSenha(String senha) throws SenhaErradoException {
        if(verificaSenha(senha)){
            return "Senha atende aos requisitos";
        }else{
            throw new SenhaErradoException();
        }
    }

    public boolean verificaSenha(String senha) {
        boolean maiuscula = false;
        boolean minuscula = false;
        boolean digito = false;
        boolean especial = false;
        if (senha.length() < 6) {
            return false;
        } else {
            for (int i = 0; i < senha.length(); i++) {
                char c = senha.charAt(i);
                if (Character.isUpperCase(c)) {
                    maiuscula = true;
                } else if (Character.isLowerCase(c)) {
                    minuscula = true;
                } else if (Character.isDigit(c)) {
                    digito = true;
                } else {
                    especial = true;
                }
            }
        }

        if (maiuscula && minuscula && digito && especial) {
            return true;
        }else {
            return false;
        }

    }

}
