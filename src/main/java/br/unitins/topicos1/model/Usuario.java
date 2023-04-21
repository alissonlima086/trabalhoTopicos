package br.unitins.topicos1.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Usuario extends Pessoa{

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    
    
}
