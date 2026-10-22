package br.edu.ifpe.oxefood.api.cliente;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.SQLRestriction;

import br.edu.ifpe.oxefood.modelo.cliente.EnderecoCliente;
import br.edu.ifpe.oxefood.util.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
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

    @OneToMany(mappedBy = "cliente", orphanRemoval = true, fetch = FetchType.EAGER)
    private List<EnderecoCliente> enderecos;

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