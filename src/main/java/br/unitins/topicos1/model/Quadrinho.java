package br.unitins.topicos1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Quadrinho extends Produto{

    private Encadernacao encadernacao;

    private Integer quantPaginas;
    private String descricao;
    private String idioma;

    @ManyToOne
    @JoinColumn(name = "id_autor")
    private Autor autor;

    @ManyToOne
    @JoinColumn(name = "id_ilustrador")
    private Ilustrador ilustrador;

    @ManyToOne
    @JoinColumn(name = "id_editora")
    private Editora editora;

    
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

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    
    
    
}