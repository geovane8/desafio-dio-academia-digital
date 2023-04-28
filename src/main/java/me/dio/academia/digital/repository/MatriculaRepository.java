package me.dio.academia.digital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import me.dio.academia.digital.entity.Matricula;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

  @Query(value = "SELECT m FROM Matricula m JOIN m.aluno a WHERE a.bairro = :bairro")
  List<Matricula> findAlunosMatriculadosBairro(@Param("bairro") String bairro);

}
