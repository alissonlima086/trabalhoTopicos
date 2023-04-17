package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Autor;
import br.unitins.topicos1.model.Encadernacao;
import br.unitins.topicos1.model.Quadrinho;

public record QuadrinhoDTO(
    Long idQuadrinho,
    String nome,
    Integer estoque,
    Integer quantPaginas,
    Double preco,
    String descricao,
    String idioma,
    Integer encadernacao,
    Long autor
){
    public QuadrinhoDTO(Quadrinho quadrinho){
        this(quadrinho.getId(), quadrinho.getNome(), quadrinho.getEstoque(), quadrinho.getQuantPaginas(),quadrinho.getPreco(), quadrinho.getDescricao(), quadrinho.getIdioma(), quadrinho.getEncadernacao().getId(), quadrinho.getAutor().getId());
    }

}