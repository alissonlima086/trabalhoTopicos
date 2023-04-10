package br.unitins.topicos1.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.JoinTable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Quadrinho extends DefaultEntity{

    private String nome;
    private Double preco;
    private Integer estoque;

    private Encadernacao encadernacao;

    private Integer quantPaginas;
    private String descricao;
    private String idioma;

    @ManyToOne
    private Autor autor;

    @ManyToOne
    private Ilustrador ilustrador;

    @ManyToOne
    private Publisher publisher;

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

    public Encadernacao getEncadernacao() {
        return encadernacao;
    }

    public void setEncadernacao(Encadernacao encadernacao) {
        this.encadernacao = encadernacao;
    }

    public Integer getQuantPaginas() {
        return quantPaginas;
    }

    public void setQuantPaginas(Integer quantPaginas) {
        this.quantPaginas = quantPaginas;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Ilustrador getIlustrador() {
        return ilustrador;
    }

    public void setIlustrador(Ilustrador ilustrador) {
        this.ilustrador = ilustrador;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    
    
}
