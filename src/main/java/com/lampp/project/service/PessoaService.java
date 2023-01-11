package com.lampp.project.service;

import com.lampp.project.common.utils.MessageResource;
import com.lampp.project.model.Pessoa;
import com.lampp.project.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PessoaService {

    private final PessoaRepository repository;

    public List<Pessoa> findAll() {
        return repository.findAll();
    }

    public Optional<Pessoa> findById(Long id) {
        return repository.findById(id);
    }

    public Optional<Pessoa> delete(Long id) {
        Optional<Pessoa> pessoa = repository.findById(id);
        pessoa.ifPresent(repository::delete);
        return pessoa;
    }

    public Pessoa save(Pessoa pessoa) {
        return repository.save(pessoa);
    }
}
