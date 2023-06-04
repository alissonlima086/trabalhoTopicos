package br.unitins.topicos1.dto;

import jakarta.validation.constraints.NotBlank;

public record IlustradorDTO (
    @NotBlank(message = "O campo nome deve ser ingormado")
    String nome,
    @NotBlank(message = "O campo cpf deve ser informado")
    String cpf,
    String bio
){


    
}
