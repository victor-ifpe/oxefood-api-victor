package br.edu.ifpe.oxefood.api.categoriaProduto;

import org.hibernate.annotations.SQLRestriction;

import br.edu.ifpe.oxefood.util.EntidadeAuditavel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CategoriaProduto")
@SQLRestriction("Habilitado = true")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CategoriaProduto extends EntidadeAuditavel {

    @Column
    private String descricao;

}