package br.edu.ifpe.oxefood.api.categoriaProduto;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categoria-produto")
public class CategoriaProdutoController {

    private final CategoriaProdutoService service;

    public CategoriaProdutoController(CategoriaProdutoService service) {
        this.service = service;
    }

    @PostMapping
    public CategoriaProduto cadastrar(@RequestBody CategoriaProduto categoria) {
        return service.cadastrar(categoria);
    }

    @GetMapping
    public List<CategoriaProduto> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public CategoriaProduto buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
}