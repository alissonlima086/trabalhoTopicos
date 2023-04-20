package br.unitins.topicos1.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public record QuadrinhoDTO(
    @NotNull(message = "O campo idQuadrinho deve ser informado.")
    Long idQuadrinho,

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

    @NotNull(message = "O campo autor deve ser informado")
    Long autor
){


}