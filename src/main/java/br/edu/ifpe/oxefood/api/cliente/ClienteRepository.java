package br.edu.ifpe.oxefood.api.cliente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    // Busca aproximada pelo nome, sem diferenciar maiúsculas de minúsculas
    List<Cliente> findByNomeContainingIgnoreCaseOrderByNomeAsc(String nome);

    // Busca aproximada pelo CPF (armazenado somente com dígitos)
    List<Cliente> findByCpfContainingOrderByNomeAsc(String cpf);

}