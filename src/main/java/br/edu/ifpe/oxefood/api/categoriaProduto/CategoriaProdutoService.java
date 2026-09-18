package br.edu.ifpe.oxefood.api.categoriaProduto;

import java.util.List;

import org.springframework.stereotype.Service;

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
}