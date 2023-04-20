package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Ilustrador;

public record IlustradorResponseDTO (
    Long id,
    String nome,
    String bio
) {
    
    public IlustradorResponseDTO(Ilustrador ilustrador) {
        this(ilustrador.getId(), ilustrador.getNome(), ilustrador.getBio());
    }
    
}
