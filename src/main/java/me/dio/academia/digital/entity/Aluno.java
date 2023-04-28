package me.dio.academia.digital.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_alunos")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String cpf;

    private String bairro;

    @Column(nullable = false)
    private LocalDate dataDeNascimento;

    @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();

    public void addAvaliacao(AvaliacaoFisica avaliacao) {
        avaliacoes.add(avaliacao);
        avaliacao.setAluno(this);
    }

    public void removeAvaliacao(AvaliacaoFisica avaliacao) {
        avaliacoes.remove(avaliacao);
        avaliacao.setAluno(null);
    }

}
