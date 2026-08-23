package br.edu.ifpe.oxefood.api.produto;

import br.edu.ifpe.oxefood.api.categoriaProduto.CategoriaProduto;
import br.edu.ifpe.oxefood.api.empresa.Empresa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Anotação do lombok serve para adicionar o @Setter e o @Getter, ele funciona como se tivesse adicionando essas duas anotações
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProdutoDTO {
    
    private Long id;

    private Empresa empresa;

    private CategoriaProduto categoria;

    private String codigo;

    private String titulo;

    private String descricao;

    private Double valorUnitario;

    private Integer tempoEntregaMinimo;

    private Integer tempoEntregaMaximo;
    
}