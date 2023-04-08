package br.unitins.topicos1.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import br.unitins.topicos1.model.Encadernacao;
import br.unitins.topicos1.model.Quadrinho;

public class QuadrinhoResponseDTO {

    private Long id;
    private String nome;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Encadernacao encadernacao;

    public QuadrinhoResponseDTO(Quadrinho quadrinho){
        this.id = quadrinho.getId();
        this.nome = quadrinho.getNome();
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


    
    
    
}
