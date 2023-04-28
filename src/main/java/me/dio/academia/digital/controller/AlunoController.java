package me.dio.academia.digital.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.service.AlunoService;

@RestController
@RequestMapping("/alunos")
@Validated
public class AlunoController {

  private final AlunoService alunoService;

  @Autowired
  public AlunoController(AlunoService alunoService) {
      this.alunoService = alunoService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Aluno create(@Valid @RequestBody AlunoForm form) {
    return alunoService.create(form);
  }

  @GetMapping("/avaliacoes/{id}")
  public ResponseEntity<List<AvaliacaoFisica>> getAllAvaliacaoFisicaId(@PathVariable Long id) {
    List<AvaliacaoFisica> avaliacoes = alunoService.getAllAvaliacaoFisicaId(id);
    if(avaliacoes.isEmpty()) {
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(avaliacoes);
  }

  @GetMapping
  public ResponseEntity<List<Aluno>> getAll(@RequestParam(value = "dataDeNascimento", required = false) String dataDeNascimento){
    List<Aluno> alunos = alunoService.getAll(dataDeNascimento);
    if(alunos.isEmpty()) {
        return ResponseEntity.noContent().build();
    }
    return ResponseEntity.ok(alunos);
  }
}
