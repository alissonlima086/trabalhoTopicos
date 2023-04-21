package br.unitins.topicos1.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Editora extends DefaultEntity {
    
    @Column(length = 60)
    private String nome;

    @OneToMany(mappedBy = "editora")
    private List<Quadrinho> quadrinhos = new ArrayList<Quadrinho>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Quadrinho> getQuadrinhos() {
        return quadrinhos;
    }

    public void setQuadrinhos(List<Quadrinho> quadrinhos) {
        this.quadrinhos = quadrinhos;
    }

    
    
}