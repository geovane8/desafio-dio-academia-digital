package me.dio.academia.digital.entity.form;

import java.time.LocalDate;

public record AlunoUpdateForm(String nome, String bairro, LocalDate dataDeNascimento) {
  
  public LocalDate getDataDeNascimento() {
    return dataDeNascimento;
}

  public void setNome(String nome) {
    throw new UnsupportedOperationException("Cannot set nome in AlunoUpdateForm");
}

public void setBairro(String bairro) {
    throw new UnsupportedOperationException("Cannot set bairro in AlunoUpdateForm");
}
