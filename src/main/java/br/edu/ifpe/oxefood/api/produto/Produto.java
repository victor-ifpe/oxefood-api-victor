package br.edu.ifpe.oxefood.api.produto;

import org.hibernate.annotations.SQLRestriction;

import br.edu.ifpe.oxefood.api.categoriaProduto.CategoriaProduto;
import br.edu.ifpe.oxefood.api.empresa.Empresa;
import br.edu.ifpe.oxefood.util.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoriaProduto categoria;

    @Column(length = 20, nullable = false, unique = true)
    private String codigo;

    @Column(length = 100, nullable = false)
    private String titulo;

    @Column(length = 255)
    private String descricao;

    @Column(nullable = false)
    private Double valorUnitario;

    @Column(nullable = false)
    private Integer tempoEntregaMinimo;

    @Column(nullable = false)
    private Integer tempoEntregaMaximo;

}