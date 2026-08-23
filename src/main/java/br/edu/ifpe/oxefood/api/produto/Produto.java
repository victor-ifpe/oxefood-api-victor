package br.edu.ifpe.oxefood.api.produto;

import org.hibernate.annotations.SQLRestriction;

import br.edu.ifpe.oxefood.api.categoriaProduto.CategoriaProduto;
import br.edu.ifpe.oxefood.api.empresa.Empresa;
import br.edu.ifpe.oxefood.util.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Produto")
@SQLRestriction("Habilitado = true")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Produto extends EntidadeAuditavel {

    @Column
    private Empresa empresa;

    @Column
    private CategoriaProduto categoria;

    @Column
    private String codigo;

    @Column
    private String titulo;

    @Column
    private String descricao;

    @Column
    private Double valorUnitario;

    @Column
    private Integer tempoEntregaMinimo;

    @Column
    private Integer tempoEntregaMaximo;
    
}
