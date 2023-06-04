package br.unitins.topicos1.dto;

import jakarta.validation.constraints.NotNull;


public record AutorDTO (
    @NotNull(message = "O idAutor deve ser informado.")
    String nome,
    String cpf,
    String bio
){


}
