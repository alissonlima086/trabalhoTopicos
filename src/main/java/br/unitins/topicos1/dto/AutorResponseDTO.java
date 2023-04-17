package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Autor;


public class AutorResponseDTO {

    private Long id;
    private String nome;
    private String bio;

    public AutorResponseDTO(Autor autor){
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.bio = autor.getBio();
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

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
    
}
