package br.unitins.topicos1.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class AutorDTO {

    @NotBlank(message = "O campo nome deve ser informado.")
    private String nome;

    @NotNull(message = "O campo idAutor deve ser informado.")
    private Long idAutor;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Long idAutor) {
        this.idAutor = idAutor;
    }

    
    
}
