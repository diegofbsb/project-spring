package com.lampp.project.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Entity
@Table(name = "pessoa")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    @Past
    @DateTimeFormat(pattern="dd-MM-yyyy")
    private LocalDate dataNacimento;
    private String observacoes;
}
