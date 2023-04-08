package br.unitins.topicos1.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class IlustradorDTO {

    @NotBlank(message = "O campo nome deve ser informado.")
    private String nome;

    @NotNull(message = "O campo idAutor deve ser informado.")
    private Long idIlustrador;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getIdIlustrador() {
        return idIlustrador;
    }

    public void setIdIlustrador(Long idIlustrador) {
        this.idIlustrador = idIlustrador;
    }

    
    
}
