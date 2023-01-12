package com.lampp.project.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "pessoa")
@Getter
@Setter
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O nome é obrigatório")
    private String name;
    @NotBlank(message = "O email é obrigatório")
    private String email;
    @NotNull(message = "O ddd é obrigatório")
    private Integer ddd;
    @NotNull(message = "O telefone é obrigatório")
    private Integer telefone;
    @NotNull(message = "O cpf é obrigatório com 11 digitos")
    private Long cpf;
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate dataNascimento;
    private String observacoes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Pessoa pessoa = (Pessoa) o;
        return id != null && Objects.equals(id, pessoa.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
