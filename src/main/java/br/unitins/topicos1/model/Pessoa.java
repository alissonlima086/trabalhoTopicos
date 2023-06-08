package br.unitins.topicos1.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
//@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa extends DefaultEntity {

    @Column(length = 60)
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    

}
