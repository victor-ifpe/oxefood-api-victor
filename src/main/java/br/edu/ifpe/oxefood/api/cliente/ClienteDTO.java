package br.edu.ifpe.oxefood.api.cliente;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Anotação do lombok serve para adicionar o @Setter e o @Getter, ele funciona como se tivesse adicionando essas duas anotações
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    @Length(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres")
    private String nome;

    @NotNull(message = "A data de nascimento é obrigatória")
    private LocalDate dataNascimento;

    @CPF(message = "O CPF é inválido")
    @NotBlank(message = "O CPF é obrigatório")
    private String cpf;

    @Length(min = 10, max = 15, message = "O telefone celular deve ter entre 10 e 15 caracteres")
    private String foneCelular;

    @Length(min = 10, max = 15, message = "O telefone fixo deve ter entre 10 e 15 caracteres")
    private String foneFixo;

}