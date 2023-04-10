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
    private String descricao;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Encadernacao encadernacao;

    public QuadrinhoResponseDTO(Long id, String nome, String idioma, Integer estoque, Integer quantPaginas,
            Double preco, String descricao, Encadernacao encadernacao) {
        this.id = id;
        this.nome = nome;
        this.idioma = idioma;
        this.estoque = estoque;
        this.quantPaginas = quantPaginas;
        this.preco = preco;
        this.descricao = descricao;
        this.encadernacao = encadernacao;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Encadernacao getEncadernacao() {
        return encadernacao;
    }

    public void setEncadernacao(Encadernacao encadernacao) {
        this.encadernacao = encadernacao;
    }


    
    
    
    
}