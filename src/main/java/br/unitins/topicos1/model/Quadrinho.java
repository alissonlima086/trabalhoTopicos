package br.unitins.topicos1.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.JoinTable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Quadrinho extends Produto{

    private Encadernacao encadernacao;

    private Integer quantPaginas;
    private String sinopse;
    private String idioma;


    // Autor
    @ManyToMany
    //@JoinTable(name = "quadrinho_autor", joinColumns = @JoinColumn(name = "quadrinho_id"), inverseJoinColumns = @JoinColumn(name = "autor_id"))
    private List<Autor> autores = new ArrayList<Autor>();

    public List<Autor> getAutores() {
        return autores;
    }
    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    // Ilustrador
    @ManyToMany
    //@JoinTable(name = "quadrinho_ilustrador", joinColumns = @JoinColumn(name = "quadrinho_id"), inverseJoinColumns = @JoinColumn(name = "ilustrador_id"))
    private List<Ilustrador> ilustradores = new ArrayList<Ilustrador>();

    public List<Ilustrador> getIlustradores() {
        return ilustradores;
    }
    public void setIlustradores(List<Ilustrador> ilustradores) {
        this.ilustradores = ilustradores;
    }

    // Publisher

    @ManyToOne
    private Publisher publisher;


    // --------------------


    // ------------------
    

    public Integer getQuantPaginas() {
        return quantPaginas;
    }
    public void setQuantPaginas(Integer quantPaginas) {
        this.quantPaginas = quantPaginas;
    }
    public String getSinopse() {
        return sinopse;
    }
    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }
    public String getIdioma() {
        return idioma;
    }
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
    public Encadernacao getEncadernacao() {
        return encadernacao;
    }
    public void setEncadernacao(Encadernacao encadernacao) {
        this.encadernacao = encadernacao;
    }
    public Publisher getPublisher() {
        return publisher;
    }
    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    

    
}
