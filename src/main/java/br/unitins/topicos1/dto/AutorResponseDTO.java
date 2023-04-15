package br.unitins.topicos1.dto;

import java.util.ArrayList;
import java.util.List;

import br.unitins.topicos1.model.Autor;
import br.unitins.topicos1.model.Quadrinho;

public class AutorResponseDTO {

    private Long id;
    private String nome;
    private String bio;
    private List<Quadrinho> quadrinhos = new ArrayList<Quadrinho>();

    public AutorResponseDTO(Autor autor){
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.bio = autor.getBio();
        this.quadrinhos = autor.getQuadrinhos();
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

    public List<Quadrinho> getQuadrinhos() {
        return quadrinhos;
    }

    public void setQuadrinhos(List<Quadrinho> quadrinhos) {
        this.quadrinhos = quadrinhos;
    }

    
}
