package br.edu.ifpe.oxefood.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class ClienteException extends RuntimeException {

    public static final String MSG_TELEFONE_INVALIDO =
            "Não é permitido inserir clientes com telefone que não tenha o prefixo 81.";

    public ClienteException(String msg) {
        super(msg);
    }
}