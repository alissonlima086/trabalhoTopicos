package br.unitins.topicos1.dto;

import javax.validation.constraints.NotBlank;

public class PosterDTO {

    @NotBlank(message = "O campo nome deve ser informado.")
    private String nome;

    private Integer tamanhoPoster;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getTamanhoPoster() {
        return tamanhoPoster;
    }

    public void setTamanhoPoster(Integer tamanhoPoster) {
        this.tamanhoPoster = tamanhoPoster;
    }

    
    
}
