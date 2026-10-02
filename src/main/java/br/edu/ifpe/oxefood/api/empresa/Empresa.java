package br.edu.ifpe.oxefood.api.empresa;

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
@Table(name = "Empresa")
@SQLRestriction("Habilitado = true")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Empresa extends EntidadeAuditavel {

    @Column(length = 100, nullable = false)
    private String site;

    @Column(length = 14, nullable = false, unique = true)
    private String cnpj;

    @Column(length = 20)
    private String inscricaoEstadual;

    @Column(length = 100, nullable = false)
    private String nomeEmpresarial;

    @Column(length = 100)
    private String nomeFantasia;

    @Column(length = 15)
    private String fone;

    @Column(length = 15)
    private String foneAlternativo;
    
}