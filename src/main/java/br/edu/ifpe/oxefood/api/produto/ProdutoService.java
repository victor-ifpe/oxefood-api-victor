package br.edu.ifpe.oxefood.api.produto;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifpe.oxefood.api.empresa.Empresa;
import br.edu.ifpe.oxefood.api.empresa.EmpresaRepository;
import jakarta.transaction.Transactional;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;
    private final EmpresaRepository empresaRepository;

    public ProdutoService(
            ProdutoRepository repository,
            EmpresaRepository empresaRepository) {
        this.repository = repository;
        this.empresaRepository = empresaRepository;
    }

    public Produto build(ProdutoDTO dto) {

        Produto produto = new Produto();

        if (dto.getEmpresa() != null) {
            Empresa empresa = empresaRepository
                    .findById(dto.getEmpresa().getId())
                    .orElseThrow(() -> new RuntimeException("Empresa não encontrada"));

            produto.setEmpresa(empresa);

        }

        produto.setCategoria(dto.getCategoria());
        produto.setCodigo(dto.getCodigo());
        produto.setTitulo(dto.getTitulo());
        produto.setDescricao(dto.getDescricao());
        produto.setValorUnitario(dto.getValorUnitario());
        produto.setTempoEntregaMinimo(dto.getTempoEntregaMinimo());
        produto.setTempoEntregaMaximo(dto.getTempoEntregaMaximo());

        return produto;
    }

    @Transactional
    public Produto cadastrar(ProdutoDTO dto) {

        Produto produto = build(dto);
        produto.setHabilitado(true);
        return repository.save(produto);
    }

    public List<Produto> listar() {
        return repository.findAll();
    }

    public Produto buscarPorId(Long id) {
        return repository.findById(id).get();
    }
}