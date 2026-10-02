package br.edu.ifpe.oxefood.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ProdutoException extends RuntimeException {

    public static final String MSG_VALOR_MINIMO_PRODUTO =
            "Não é permitido inserir produtos com valor inferior a R$ 20,00.";

    public static final String MSG_VALOR_MAXIMO_PRODUTO =
            "Não é permitido inserir produtos com valor superior a R$ 100,00.";

    public ProdutoException(String msg) {
        super(msg);
    }
}