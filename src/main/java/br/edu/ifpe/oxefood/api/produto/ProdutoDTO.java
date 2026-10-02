package br.edu.ifpe.oxefood.api.produto;

import org.hibernate.validator.constraints.Length;

import br.edu.ifpe.oxefood.api.categoriaProduto.CategoriaProduto;
import br.edu.ifpe.oxefood.api.empresa.Empresa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotBlank (message = "O código é obrigatório")
    private String codigo;

    @NotBlank(message = "O título é obrigatório")
    @Length(min = 2, max = 100, message = "O título deve ter entre 2 e 100 caracteres")
    private String titulo;

    private String descricao;

    @NotNull(message = "O valor unitário é obrigatório")
    private Double valorUnitario;
 
    @NotNull(message = "O tempo de entrega mínimo é obrigatório")
    private Integer tempoEntregaMinimo;

    @NotNull(message = "O tempo de entrega máximo é obrigatório")
    private Integer tempoEntregaMaximo;
    
}