package br.unitins.topicos1.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record IlustradorDTO (
    @NotBlank(message = "O campo nome deve ser ingormado")
    String nome,
    @NotNull(message = "O campo idIlustrador deve ser informado")
    Long idIlustrador,
    String bio
){


    
}
