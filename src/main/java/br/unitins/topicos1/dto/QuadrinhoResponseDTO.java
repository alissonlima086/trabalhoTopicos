package br.unitins.topicos1.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import br.unitins.topicos1.model.Encadernacao;
import br.unitins.topicos1.model.Quadrinho;

public class QuadrinhoResponseDTO {

    private Long id;

    private String nome;
    private String idioma;
    private Integer estoque;
    private Integer quantPaginas;
    private Double preco;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Encadernacao encadernacao;
    

    public QuadrinhoResponseDTO(Quadrinho quadrinho) {
        this.id = quadrinho.getId();
        this.nome = quadrinho.getNome();
        this.idioma = quadrinho.getIdioma();
        this.estoque = quadrinho.getEstoque();
        this.quantPaginas = quadrinho.getQuantPaginas();
        this.preco = quadrinho.getPreco();
        this.encadernacao = quadrinho.getEncadernacao();
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

    public Encadernacao getEncadernacao() {
        return encadernacao;
    }

    public void setEncadernacao(Encadernacao encadernacao) {
        this.encadernacao = encadernacao;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public Integer getQuantPaginas() {
        return quantPaginas;
    }

    public void setQuantPaginas(Integer quantPaginas) {
        this.quantPaginas = quantPaginas;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
    
    
    
}
