package br.unitins.topicos1.dto;

import jakarta.validation.constraints.NotNull;

public record ListaDesejoDTO(
    @NotNull
    Long idUsuario,
    Long idProduto
) {
    
}