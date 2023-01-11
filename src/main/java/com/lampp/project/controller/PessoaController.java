package com.lampp.project.controller;

import com.lampp.project.model.Pessoa;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/pessoa")
@RequiredArgsConstructor
@Tag(name = "Projeto test para LAMPP", description = "Controller para CRUD do cadastro de pessoas.")
public class PessoaController {

    private final PessoaFacade pessoaFacade;

    @GetMapping
    @Operation(summary = "Busca todas as pessoas cadastradas.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Dados encontrados"),
                    @ApiResponse(responseCode = "400", description = "Dados informados invalidos"),
                    @ApiResponse(responseCode = "422", description = "O servico nao ira processar a requisicao"),
                    @ApiResponse(responseCode = "500", description = "ocorreu um erro inesperado")
            })
    @ResponseStatus(HttpStatus.OK)
    public List<Pessoa> findAll() {
        return pessoaFacade.findAll();
    }

    @PostMapping("/{id}")
    @Operation(summary = "Busca as pessoas por id.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Dados encontrados"),
                    @ApiResponse(responseCode = "400", description = "Dados informados invalidos"),
                    @ApiResponse(responseCode = "422", description = "O servico nao ira processar a requisicao"),
                    @ApiResponse(responseCode = "500", description = "ocorreu um erro inesperado")
            })
    @ResponseStatus(HttpStatus.OK)
    public Optional<Pessoa> findById(@PathVariable("id") Long id) {
        return pessoaFacade.findById(id);
    }

    @PostMapping("/delete/{id}")
    @Operation(summary = "Deleta as pessoas por id.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Dados encontrados"),
                    @ApiResponse(responseCode = "400", description = "Dados informados invalidos"),
                    @ApiResponse(responseCode = "422", description = "O servico nao ira processar a requisicao"),
                    @ApiResponse(responseCode = "500", description = "ocorreu um erro inesperado")
            })
    @ResponseStatus(HttpStatus.OK)
    public Optional<Pessoa> delete(@PathVariable("id") Long id) {
        return pessoaFacade.delete(id);
    }

    @PostMapping
    @Operation(summary = "Salva pessoa.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Dados encontrados"),
                    @ApiResponse(responseCode = "400", description = "Dados informados invalidos"),
                    @ApiResponse(responseCode = "422", description = "O servico nao ira processar a requisicao"),
                    @ApiResponse(responseCode = "500", description = "ocorreu um erro inesperado")
            })
    @ResponseStatus(HttpStatus.OK)
    public Optional<Pessoa> save(@RequestBody Pessoa pessoa) {
        return Optional.ofNullable(pessoaFacade.save(pessoa));
    }
}
