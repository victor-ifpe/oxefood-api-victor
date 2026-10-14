package br.edu.ifpe.oxefood.api.voto;

import java.time.LocalDate;

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
@Table(name = "Voto")
@SQLRestriction("habilitado = true")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Voto extends EntidadeAuditavel {

    @Column
    private Long id;

    @Column
    private String nomeEleitor;

    @Column
    private String numeroRegistroEleitoral;

    @Column
    private LocalDate dataVotacao;

    @Column
    private Integer numeroCandidatoDepFederal;

    @Column
    private Integer numeroCandidatoDepEstadual;

    @Column
    private Integer numeroCandidatoSenador;

    @Column
    private Integer numeroCandidatoGovernador;

    @Column
    private Integer numeroCandidatoPresidente;

}