package br.edu.ifpe.oxefood.util;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;


// Cria os métodos Getters e Setters da class sem precisar escrever o código em si, deixar o arquivo mais resumido
@Getter 
@Setter
public abstract class EntidadeAuditavel extends EntidadeNegocio {

    private Long versao;

    private LocalDate dataCriacao;

    private LocalDate dataUltimaModificacao;

    private Long criadoPor; // Id do usuário que o criou

    private Long ultimaModificacaoPor; // Id do usuário que fez a última alteração

}
