package br.edu.ifpe.oxefood.api.voto;

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
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/voto")
public class VotoController {

  private final VotoService votoService;

  public VotoController(VotoService service) {
    this.votoService = service;
  }

  @PostMapping
  public ResponseEntity<Voto> cadastrar(@RequestBody @Valid VotoDTO dto) {
    Voto votoCadastrado = votoService.cadastrar(dto);
    return ResponseEntity.status(HttpStatus.CREATED).body(votoCadastrado);
  }

  @GetMapping
  public ResponseEntity<List<Voto>> listar() {
    return ResponseEntity.ok(votoService.listar());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Voto> buscarPorId(@PathVariable Long id) {
    return ResponseEntity.ok(votoService.buscarPorId(id));
  }

  @PutMapping
  public ResponseEntity<Voto> atualizar(@RequestBody @Valid VotoDTO dto) {

    Voto votoAtualizado = votoService.atualizar(dto);
    return ResponseEntity.ok(votoAtualizado);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> remover(@PathVariable Long id) {

    votoService.remover(id);
    return ResponseEntity.noContent().build();
  }

}