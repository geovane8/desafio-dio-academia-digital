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
@Table(name = "tb_avaliacoes")
public class AvaliacaoFisica {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;
    
    @Column(name = "data_da_avaliacao", columnDefinition = "TIMESTAMP")
    private LocalDateTime dataDaAvaliacao;
    
    private double peso;
    
    private double altura;
    
    public AvaliacaoFisica(Aluno aluno, double peso, double altura) {
        this.aluno = aluno;
        this.peso = peso;
        this.altura = altura;
        this.dataDaAvaliacao = LocalDateTime.now();
    }
}
