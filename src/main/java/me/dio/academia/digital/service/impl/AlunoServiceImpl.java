package me.dio.academia.digital.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.infra.utils.JavaTimeUtils;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.service.IAlunoService;

@Service
public class AlunoServiceImpl implements IAlunoService {

    private final AlunoRepository repository;

    @Autowired
    public AlunoServiceImpl(AlunoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Aluno create(AlunoForm form) {
        Aluno aluno = new Aluno(form.getNome(), form.getCpf(), form.getBairro(), form.getDataDeNascimento());
        return repository.save(aluno);
    }

    @Override
    public Optional<Aluno> get(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Aluno> getAll(LocalDate dataDeNascimento) {
        return dataDeNascimento != null ? repository.findByDataDeNascimento(dataDeNascimento)
                : repository.findAll();
    }

    @Override
    public Optional<Aluno> update(Long id, AlunoUpdateForm formUpdate) {
        Optional<Aluno> optionalAluno = repository.findById(id);
        optionalAluno.ifPresent(aluno -> {
            aluno.setNome(formUpdate.getNome());
            aluno.setCpf(formUpdate.getCpf());
            aluno.setBairro(formUpdate.getBairro());
            aluno.setDataDeNascimento(formUpdate.getDataDeNascimento());
            repository.save(aluno);
        });
        return optionalAluno;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<AvaliacaoFisica> getAllAvaliacaoFisica(Long id) {
        Optional<Aluno> optionalAluno = repository.findById(id);
        return optionalAluno.map(Aluno::getAvaliacoes).orElse(List.of());
    }

}
