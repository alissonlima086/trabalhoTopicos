package br.unitins.topicos1.dto;

import javax.validation.constraints.NotBlank;


public class QuadrinhoDTO {

    @NotBlank(message = "O campo nome deve ser informado.")
    private String nome;

    private Integer encadernacao;

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getEncadernacao() {
        return encadernacao;
    }

    public void setEncadernacao(Integer encadernacao) {
        this.encadernacao = encadernacao;
    }

    
    
}
