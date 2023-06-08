package br.unitins.topicos1.dto;

public record DadosLoginResponseDTO (
    String login,
    String nome,
    String email,
    String cpf,
    String sexo
){
    public DadosLoginResponseDTO (UsuarioResponseDTO usuario){
        this(usuario.login(), usuario.nome(), usuario.email(), usuario.cpf(), usuario.sexo().getLabel());
    }
}
