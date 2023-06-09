package br.unitins.topicos1.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PessoaFisicaDTO(

    @NotBlank(message = "O campo cpf deve ser informado.")
    @Size(max = 14, message = "O cpf deve posssuir no máximo 14 caracteres.")
    String cpf,
    String email,

    @NotBlank(message = "O campo nome deve ser informado.")
    String nome,

    Integer sexo
) {
  
}
