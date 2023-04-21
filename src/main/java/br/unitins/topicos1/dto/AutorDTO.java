package br.unitins.topicos1.dto;

import javax.validation.constraints.NotBlank;


public record AutorDTO (
    @NotBlank(message = "O campo nome deve ser informado.")
    String nome,
    @NotBlank(message = "O campo bio deve ser informado.")
    String bio,
    @NotBlank(message = "O campo cpf deve ser informado.")
    String cpf
){

}
