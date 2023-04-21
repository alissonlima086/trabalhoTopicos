package br.unitins.topicos1.dto;

import javax.validation.constraints.NotBlank;

public record UsuarioDTO (
    @NotBlank(message = "O campo idUsuario deve ser informado.")
    String nome,
    @NotBlank(message = "O campo cpf deve ser informado.")
    String cpf,
    @NotBlank(message = "O campo email deve ser informado.")
    String email,
    @NotBlank(message = "O campo senha deve ser informado.")
    String senha
){
    
}
