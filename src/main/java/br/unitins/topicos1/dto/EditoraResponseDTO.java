package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Editora;

public record EditoraResponseDTO (
    String nome
){
    public EditoraResponseDTO(Editora editora){
        this(editora.getNome());
    }
}
