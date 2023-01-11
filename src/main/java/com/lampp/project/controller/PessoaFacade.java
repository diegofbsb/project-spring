package com.lampp.project.controller;

import com.lampp.project.model.Pessoa;
import com.lampp.project.service.PessoaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class PessoaFacade {

    private final PessoaService pessoaService;

    public List<Pessoa> findAll() {
        return pessoaService.findAll();
    }

    public Optional<Pessoa> findById(Long id) {
        return pessoaService.findById(id);
    }

    public Optional<Pessoa> delete(Long id) {
        return pessoaService.delete(id);
    }

    public Pessoa save(Pessoa pessoa) {
        return pessoaService.save(pessoa);
    }

}
