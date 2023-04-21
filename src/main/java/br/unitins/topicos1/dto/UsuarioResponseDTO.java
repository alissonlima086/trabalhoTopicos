package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Usuario;

public record UsuarioResponseDTO (
    Long id,
    String nome,
    String email,
    String cpf
){
    public UsuarioResponseDTO(Usuario usuario){
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getCpf());
    }
    
}
