package me.dio.academia.digital.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.service.AvaliacaoFisicaService;

@RestController
@RequestMapping("/avaliacoes")
@Validated
public class AvaliacaoFisicaController {

  private final AvaliacaoFisicaService avaliacaoFisicaService;

  @Autowired
  public AvaliacaoFisicaController(AvaliacaoFisicaService avaliacaoFisicaService) {
      this.avaliacaoFisicaService = avaliacaoFisicaService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public AvaliacaoFisica create(@Valid @RequestBody AvaliacaoFisicaForm form) {
    return avaliacaoFisicaService.create(form);
  }

  @GetMapping
  public ResponseEntity<List<AvaliacaoFisica>> getAll(){
    List<AvaliacaoFisica> avaliacoes = avaliacaoFisicaService.getAll();
    if(avaliacoes.isEmpty()) {
        return ResponseEntity.noContent().build();
    }
    return ResponseEntity.ok(avaliacoes);
  }

  @GetMapping("/{id}")
  public ResponseEntity<AvaliacaoFisica> getById(@PathVariable Long id) {
    AvaliacaoFisica avaliacao = avaliacaoFisicaService.getById(id);
    if(avaliacao == null) {
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(avaliacao);
  }

  @PutMapping("/{id}")
  public ResponseEntity<AvaliacaoFisica> update(@PathVariable Long id, @Valid @RequestBody AvaliacaoFisicaForm form) {
    AvaliacaoFisica avaliacao = avaliacaoFisicaService.update(id, form);
    if(avaliacao == null) {
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(avaliacao);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    boolean deleted = avaliacaoFisicaService.delete(id);
    if(!deleted) {
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.noContent().build();
  }
}
