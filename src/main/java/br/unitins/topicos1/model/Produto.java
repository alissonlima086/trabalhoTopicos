package br.unitins.topicos1.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Produto extends DefaultEntity{

    @Column(nullable = false, length = 60)
    private String nome;

    @Column(nullable = false)
    private Double preco;

    @Column(nullable = false)
    private Integer estoque;


    // --------------

    // -------------
    

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Double getPreco() {
        return preco;
    }
    public void setPreco(Double preco) {
        this.preco = preco;
    }
    public Integer getEstoque() {
        return estoque;
    }
    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

}
