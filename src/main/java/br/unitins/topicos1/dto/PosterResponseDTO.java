package br.unitins.topicos1.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import br.unitins.topicos1.model.Poster;
import br.unitins.topicos1.model.TamanhoPoster;

public class PosterResponseDTO {

    private Long id;
    private String nome;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private TamanhoPoster tamanhoPoster;

    public PosterResponseDTO(Poster poster){
        this.id = poster.getId();
        this.nome = poster.getNome();
        this.tamanhoPoster = poster.getTamanhoPoster();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TamanhoPoster getTamanhoPoster() {
        return tamanhoPoster;
    }

    public void setTamanhoPoster(TamanhoPoster tamanhoPoster) {
        this.tamanhoPoster = tamanhoPoster;
    }


    
    
    

    
    
}
