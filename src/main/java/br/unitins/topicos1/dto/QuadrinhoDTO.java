package br.unitins.topicos1.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class QuadrinhoDTO {

    @NotBlank(message = "O campo nome deve ser informado.")
    private String nome;

    @NotNull(message = "O campo idProduto deve ser informado.")
    private Long idProduto;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getidProduto() {
        return idProduto;
    }

    public void setidProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    
    
}
