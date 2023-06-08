package br.unitins.topicos1.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record QuadrinhoDTO(
    @NotBlank(message = "O campo nome deve ser informado.")
    String nome,

    @NotNull(message = "O campo estoque deve ser informado.")
    Integer estoque,

    @NotNull(message = "O campo quantPaginas deve ser informado")
    Integer quantPaginas,

    @NotNull(message = "O campo preco deve ser informado")
    Double preco,

    @NotBlank(message = "O campo descricao deve ser informado")
    String descricao,

    String idioma,

    @NotNull(message = "O campo encadernacao deve ser informado")
    Integer encadernacao,

    Long autor,


    Long editora
){

    public QuadrinhoDTO(String string, int i, int j, int k, String string2, String string3, int l) {
    }


}