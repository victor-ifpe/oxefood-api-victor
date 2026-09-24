package br.edu.ifpe.oxefood.api.categoriaProduto;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class CategoriaProdutoService {

    private final CategoriaProdutoRepository repository;

    public CategoriaProdutoService(CategoriaProdutoRepository repository) {
        this.repository = repository;
    }

    public CategoriaProduto cadastrar(CategoriaProduto categoria) {
        categoria.setHabilitado(true);
        return repository.save(categoria);
    }

    public List<CategoriaProduto> listar() {
        return repository.findAll();
    }

    public CategoriaProduto buscarPorId(Long id) {
        return repository.findById(id).get();
    }

    @Transactional
    public CategoriaProduto atualizar(CategoriaProdutoDTO dto) {

        CategoriaProduto categoriaProduto = repository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        categoriaProduto.setDescricao(dto.getDescricao());

        return repository.save(categoriaProduto);
    }

    @Transactional
    public void deletar(Long id) {
        repository.deleteById(id);
    }

}