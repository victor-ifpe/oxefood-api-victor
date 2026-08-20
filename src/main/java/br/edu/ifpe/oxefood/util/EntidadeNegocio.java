package br.edu.ifpe.oxefood.util;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

// Cria os métodos Getters e Setters da class sem precisar escrever o código em si, deixar o arquivo mais resumido
@Getter
@Setter
@EqualsAndHashCode(of = { "id" })
public abstract class EntidadeNegocio {

    private Long id;

    private Boolean habilitado;
    
}
