package br.unitins.topicos1.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public record AutorDTO (
    @NotNull(message = "O idAutor deve ser informado.")
    Long idAutor,
    String nome,
    String cpf,
    String bio
){


}
