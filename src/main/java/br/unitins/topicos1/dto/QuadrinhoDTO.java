package br.unitins.topicos1.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class QuadrinhoDTO {

    @NotNull(message = "O campo idQuadrinho deve ser informado.")
    private Long idQuadrinho;

    @NotBlank(message = "O campo nome deve ser informado.")
    private String nome;

    private Integer estoque;

    private Integer encadernacao;

    private String descricao;

    private Integer quantPaginas;

    private Double preco;

    private String idioma;

    public Long getIdQuadrinho() {
        return idQuadrinho;
    }

    public void setIdQuadrinho(Long idQuadrinho) {
        this.idQuadrinho = idQuadrinho;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public Integer getEncadernacao() {
        return encadernacao;
    }

    public void setEncadernacao(Integer encadernacao) {
        this.encadernacao = encadernacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }


    


}
