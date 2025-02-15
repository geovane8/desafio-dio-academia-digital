package me.dio.academia.digital.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

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

  @Column(name = "data_da_matricula")
  private LocalDateTime dataDaMatricula = LocalDateTime.now();

  public Matricula(Aluno aluno) {
      this.aluno = aluno;
  }

  public LocalDateTime getDataDaMatricula() {
      return dataDaMatricula;
  }

  public void setDataDaMatricula(LocalDateTime dataDaMatricula) {
      this.dataDaMatricula = dataDaMatricula;
  }
}
