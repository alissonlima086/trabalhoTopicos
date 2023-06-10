package br.unitins.topicos1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class CartaoCredito extends FormaPagamento {

    @Column(nullable = false)
    private String numeroCartao;

    @Column(nullable = false)
    private String nomeCartao;

    @Column(nullable = false)
    private String cpfTitular;

    private BandeiraCartao bandeiraCartao;

    public CartaoCredito(Double valor, String numeroCartao, String nomeCartao,
            String cpfTitular, BandeiraCartao bandeiraCartao) {

        super(valor);

        this.numeroCartao = numeroCartao;
        this.nomeCartao = nomeCartao;
        this.cpfTitular = cpfTitular;
        this.bandeiraCartao = bandeiraCartao;
    }

    public CartaoCredito() {

    }

    public String getNumeroDoCartao() {
        return numeroCartao;
    }

    public void setNumeroDoCartao(String numeroDoCartao) {
        this.numeroCartao = numeroDoCartao;
    }

    public String getNomeCartao() {
        return nomeCartao;
    }

    public void setNomeCartao(String nomeCartao) {
        this.nomeCartao = nomeCartao;
    }

    public String getCpfDoTitular() {
        return cpfTitular;
    }

    public void setCpfDoTitular(String cpfDoTitular) {
        this.cpfTitular = cpfDoTitular;
    }

    public BandeiraCartao getBandeiraCartao() {
        return bandeiraCartao;
    }

    public void setBandeiraCartao(BandeiraCartao bandeiraCartao) {
        this.bandeiraCartao = bandeiraCartao;
    }

}
