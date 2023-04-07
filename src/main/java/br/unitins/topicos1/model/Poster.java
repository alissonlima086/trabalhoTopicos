package br.unitins.topicos1.model;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Poster extends Produto{

    private TamanhoPoster tamanhoPoster;

    private String descicao;

    // Ilustrador 
    @ManyToOne
    @JoinColumn(name = "ilustrador_id")
    private Ilustrador ilustrador;

    public Ilustrador getIlustrador() {
        return ilustrador;
    }

    // ------------

    public Poster(String nome, Double preco, Integer estoque, TamanhoPoster tamanhoPoster, String descicao,
            Ilustrador ilustrador) {
        super(nome, preco, estoque);
        this.tamanhoPoster = tamanhoPoster;
        this.descicao = descicao;
        this.ilustrador = ilustrador;
    }

    // -----------

    

    public void setIlustrador(Ilustrador ilustrador) {
        this.ilustrador = ilustrador;
    }

    public TamanhoPoster getTamanhoPoster() {
        return tamanhoPoster;
    }

    public void setTamanhoPoster(TamanhoPoster tamanhoPoster) {
        this.tamanhoPoster = tamanhoPoster;
    }
    public String getDescicao() {
        return descicao;
    }

    public void setDescicao(String descicao) {
        this.descicao = descicao;
    }
}
