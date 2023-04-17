package br.unitins.topicos1.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class AutorDTO {

    @NotNull(message = "O campo idAutor deve ser informado.")
    private Long idAutor;

    @NotBlank(message = "O campo nome deve ser informado.")
    private String nome;

    private String bio;

    

    public Long getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Long idAutor) {
        this.idAutor = idAutor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }


}
