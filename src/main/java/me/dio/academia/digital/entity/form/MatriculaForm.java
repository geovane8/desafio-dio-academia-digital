package me.dio.academia.digital.entity.form;

import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class MatriculaForm {

    @NotNull(message = "O Id do aluno não pode ser nulo.")
    @Positive(message = "O Id do aluno precisa ser positivo.")
    private Long alunoId;

}
