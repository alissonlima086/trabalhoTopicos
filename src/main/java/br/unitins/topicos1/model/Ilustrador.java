package br.unitins.topicos1.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Ilustrador extends Pessoa{

    private String bio;

    // Quadrinho

    @ManyToMany(mappedBy = "ilustradores")
    private List<Quadrinho> quadrinhos = new ArrayList<Quadrinho>();

    public List<Quadrinho> getQuadrinhos() {
        return quadrinhos;
    }

    public void setQuadrinhos(List<Quadrinho> quadrinhos) {
        this.quadrinhos = quadrinhos;
    }

    // Poster

    @OneToMany(mappedBy = "ilustradores")
    private List<Poster> posters = new ArrayList<Poster>();

    public List<Poster> getPosters() {
        return posters;
    }

    public void setPosters(List<Poster> posters) {
        this.posters = posters;
    }


    // -------------

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
    
}
