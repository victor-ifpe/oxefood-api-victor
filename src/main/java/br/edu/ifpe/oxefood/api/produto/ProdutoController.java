package br.edu.ifpe.oxefood.api.produto;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/produto")
@Tag(name = "API Produto", description = "API responsável pelos serviços de produto no sistema")

public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService service) {
        this.produtoService = service;
    }

    @PostMapping
    public ResponseEntity<Produto> cadastrar(@RequestBody @Valid ProdutoDTO dto) {
        Produto produtoCadastrado = produtoService.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoCadastrado);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listar() {
        return ResponseEntity.ok(produtoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(produtoService.buscarPorId(id));
    }

    @PutMapping
    public ResponseEntity<Produto> atualizar(@RequestBody @Valid ProdutoDTO dto) {

        Produto produtoAtualizado = produtoService.atualizar(dto);
        return ResponseEntity.ok(produtoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {

        produtoService.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/filtrar")
    public List<Produto> filtrar(
            @RequestParam(value = "codigo", required = false) String codigo,
            @RequestParam(value = "titulo", required = false) String titulo,
            @RequestParam(value = "idCategoria", required = false) Long idCategoria) {

        return produtoService.filtrar(codigo, titulo, idCategoria);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Produto> saveImage(@PathVariable Long id,
            @RequestParam(value = "imagem", required = true) MultipartFile imagem) {

        Produto produto = produtoService.saveImage(id, imagem);
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

}