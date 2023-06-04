package br.unitins.topicos1.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;


@Entity
public class Autor extends Pessoa{

    private String bio;

    @OneToMany(mappedBy = "autor")
    private List<Quadrinho> quadrinhos = new ArrayList<Quadrinho>();

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
