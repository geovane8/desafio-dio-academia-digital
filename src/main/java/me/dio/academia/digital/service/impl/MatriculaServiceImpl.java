package me.dio.academia.digital.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.MatriculaRepository;
import me.dio.academia.digital.service.IMatriculaService;

@Service
@Transactional
public class MatriculaServiceImpl implements IMatriculaService {

    private final MatriculaRepository matriculaRepository;
    private final AlunoRepository alunoRepository;

    @Autowired
    public MatriculaServiceImpl(MatriculaRepository matriculaRepository, AlunoRepository alunoRepository) {
        this.matriculaRepository = matriculaRepository;
        this.alunoRepository = alunoRepository;
    }

    @Override
    public Matricula create(MatriculaForm form) {
        Aluno aluno = alunoRepository.findById(form.getAlunoId())
                .orElseThrow(() -> new IllegalArgumentException("Aluno não encontrado"));

        Matricula matricula = new Matricula(aluno);

        return matriculaRepository.save(matricula);
    }

    @Override
    public Matricula get(Long id) {
        return matriculaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Matrícula não encontrada"));
    }

    @Override
    public List<Matricula> getAll(String bairro) {
        if (bairro == null) {
            return matriculaRepository.findAll();
        } else {
            return matriculaRepository.findAlunosMatriculadosBairro(bairro);
        }
    }

    @Override
    public void delete(Long id) {
        Optional<Matricula> optionalMatricula = matriculaRepository.findById(id);
        if (optionalMatricula.isPresent()) {
            matriculaRepository.delete(optionalMatricula.get());
        } else {
            throw new IllegalArgumentException("Matrícula não encontrada");
        }
    }
}
