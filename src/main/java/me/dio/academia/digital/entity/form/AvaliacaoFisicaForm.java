package me.dio.academia.digital.entity.form;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoFisicaForm {

  @Positive(message = "O Id do aluno precisa ser positivo.")
  private Long alunoId;

  @NotNull(message = "Preencha o campo corretamente.")
  @Positive(message = "{validation.positive}")
  private Double peso;

  @NotNull(message = "Preencha o campo corretamente.")
  @Positive(message = "{validation.positive}")
  @DecimalMin(value = "150", message = "{validation.decimalMin}")
  private Double altura;

  public void setAlunoId(Long alunoId) {
    this.alunoId = alunoId;
  }

  public void setPeso(Double peso) {
    this.peso = peso;
  }

  public void setAltura(Double altura) {
    this.altura = altura;
  }

  public Long getAlunoId() {
    return alunoId;
  }

  public Double getPeso() {
    return peso;
  }

  public Double getAltura() {
    return altura;
  }
}
