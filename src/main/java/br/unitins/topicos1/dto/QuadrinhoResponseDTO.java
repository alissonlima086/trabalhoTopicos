package br.unitins.topicos1.dto;


import com.fasterxml.jackson.annotation.JsonInclude;

import br.unitins.topicos1.model.Encadernacao;
import br.unitins.topicos1.model.Quadrinho;


public record QuadrinhoResponseDTO (
    Long id,
    String nome,
    String editora,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Integer estoque,
    Integer quantPaginas,
    Double preco,
    String descricao,
    String idioma,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Encadernacao encadernacao,
    String autor
){

    public QuadrinhoResponseDTO(Quadrinho quadrinho){
        this(quadrinho.getId(), quadrinho.getNome(), quadrinho.getEditora().getNome(), quadrinho.getEstoque(), quadrinho.getQuantPaginas(), quadrinho.getPreco(), quadrinho.getDescricao(), quadrinho.getIdioma(), quadrinho.getEncadernacao(), quadrinho.getAutor().getNome());
    }  
}