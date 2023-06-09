package br.unitins.topicos1.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Usuario extends DefaultEntity {

    private String login;
    private String senha;
    private String nomeImagem;

    @ElementCollection
    @CollectionTable(name = "perfis", joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "id"))
    @Column(name = "perfil", length = 30)
    private Set<Perfil> perfis;

    @OneToOne
    @JoinColumn(name = "id_telefone_celular", unique = true)
    private Telefone celular;

    @OneToMany(mappedBy = "usuario")
    private List<Endereco> listaEndereco;

    @OneToOne
    @JoinColumn(name = "id_pessoa_fisica", unique = true)
    private PessoaFisica pessoaFisica;


    //-----
    @OneToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    @ManyToMany
    @JoinTable(name = "lista_produtos", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_produto"))
    private List<Quadrinho> quadrinhos;

    // --------------------

    public void addPerfil(Perfil perfil){
        if(this.perfis == null){
            this.perfis = new HashSet<>();
        }

        this.perfis.add(perfil);
    }

    // ---------------------


    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Telefone getCelular() {
        return celular;
    }

    public void setCelular(Telefone celular) {
        this.celular = celular;
    }

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    public Set<Perfil> getPerfis() {
        return perfis;
    }

    public void setPerfis(Set<Perfil> perfis) {
        this.perfis = perfis;
    }

    public List<Endereco> getListaEndereco() {
        return listaEndereco;
    }

    public void setListaEndereco(List<Endereco> listaEndereco) {
        this.listaEndereco = listaEndereco;
    }

    public String getNomeImagem() {
        return nomeImagem;
    }

    public void setNomeImagem(String nomeImagem) {
        this.nomeImagem = nomeImagem;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Quadrinho> getQuadrinhos() {
        return quadrinhos;
    }

    public void setQuadrinhos(Quadrinho quadrinho) {
        this.quadrinhos.add(quadrinho);
    }


}
