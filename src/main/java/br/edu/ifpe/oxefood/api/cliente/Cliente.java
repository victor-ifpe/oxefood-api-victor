package br.edu.ifpe.oxefood.api.cliente;

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
@Table(name = "Cliente")
@SQLRestriction("habilitado = true")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente extends EntidadeAuditavel {

    @Column(length = 100, nullable = false)
    private String nome;


    @Column
    private LocalDate dataNascimento;


    @Column(length = 11, nullable = false, unique = true)
    private String cpf;

    @Column(length = 15)
    private String foneCelular;

    @Column(length = 15)
    private String foneFixo;

}