package br.edu.ifpe.oxefood.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class EmpresaException extends RuntimeException {

    public static final String MSG_LOGO_VAZIA =
            "Selecione uma imagem para a logo da empresa.";

    public static final String MSG_LOGO_FORMATO_INVALIDO =
            "A logo deve ser uma imagem nos formatos PNG, JPG, JPEG ou WEBP.";

    public static final String MSG_LOGO_TAMANHO_EXCEDIDO =
            "A logo não pode exceder 2 MB.";

    public static final String MSG_LOGO_FALHA_UPLOAD =
            "Não foi possível armazenar a logo da empresa.";

    public EmpresaException(String msg) {
        super(msg);
    }
}