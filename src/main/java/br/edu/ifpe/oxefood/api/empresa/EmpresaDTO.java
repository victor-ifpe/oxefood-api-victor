package br.edu.ifpe.oxefood.api.empresa;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Anotação do lombok serve para adicionar o @Setter e o @Getter, ele funciona como se tivesse adicionando essas duas anotações
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaDTO {

    private Long id;

    @NotBlank(message = "O site é obrigatório")
    @Length(max = 100, message = "O site não pode exceder 100 caracteres")
    private String site;

    @CNPJ(message = "O CNPJ é inválido")
    @NotBlank(message = "O CNPJ é obrigatório")
    private String cnpj;

    @Length(max = 20, message = "A inscrição estadual não pode exceder 20 caracteres")
    private String inscricaoEstadual;

    @NotBlank(message = "O nome empresarial é obrigatório")
    @Length(max = 100, message = "O nome empresarial não pode exceder 100 caracteres")
    private String nomeEmpresarial;

    @Length(max = 100, message = "O nome fantasia não pode exceder 100 caracteres")
    private String nomeFantasia;

    @Length(min = 10, max = 15, message = "O telefone celular deve ter entre 10 e 15 caracteres")
    private String fone;

    @Length(min = 10, max = 15, message = "O telefone fixo deve ter entre 10 e 15 caracteres")
    private String foneAlternativo;

}