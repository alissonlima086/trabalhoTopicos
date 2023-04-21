package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Autor;



public record AutorResponseDTO (
    Long id,
    String nome,
    String bio
){
    public AutorResponseDTO(Autor autor){
        this(autor.getId(), autor.getNome(), autor.getBio());
    }
}
