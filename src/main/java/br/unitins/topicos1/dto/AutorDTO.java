package br.unitins.topicos1.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.unitins.topicos1.model.Quadrinho;


public class AutorDTO {

    @NotNull(message = "O campo idAutor deve ser informado.")
    private Long idAutor;

    @NotBlank(message = "O campo nome deve ser informado.")
    private String nome;

    private String bio;

    private List<Quadrinho> quadrinhos = new ArrayList<Quadrinho>();
    

    public Long getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Long idAutor) {
        this.idAutor = idAutor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public List<Quadrinho> getQuadrinhos() {
        return quadrinhos;
    }

    public void setQuadrinhos(List<Quadrinho> quadrinhos) {
        this.quadrinhos = quadrinhos;
    }

}
