package br.unitins.topicos1.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class QuadrinhoDTO {

    @NotBlank(message = "O campo nome deve ser informado.")
    private String nome;
    
    @NotNull(message = "O campo idEstado deve ser informado.")
    private Long idQuadrinho;

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

    public Long getIdQuadrinho() {
        return idQuadrinho;
    }

    public void setIdQuadrinho(Long idQuadrinho) {
        this.idQuadrinho = idQuadrinho;
    }

    

    
    
}
