package me.dio.academia.digital.entity;

import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_matriculas")
public class Matricula {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "aluno_id")
  private Aluno aluno;

  @Column(name = "data_da_matricula", columnDefinition = "TIMESTAMP")
  private LocalDateTime dataDaMatricula = LocalDateTime.now();

  public Matricula(Aluno aluno) {
      this.aluno = aluno;
  }

  // Removido getters e setters desnecessários
}
