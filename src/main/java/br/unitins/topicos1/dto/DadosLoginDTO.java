package br.unitins.topicos1.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosLoginDTO(

    @NotBlank(message = "O campo email deve ser preenchido")
    String email,
    @NotNull
    @Min(1)
    Integer sexo
){

}
