package br.unitins.topicos1.model;

public class Endereco extends DefaultEntity{
    
    private boolean isPrincipal;

    private String logradouro;

    private String bairro;

    private String numero;

    private String complemento;

    private Estado estado;
    
    private Municipio municipio;

    public boolean isPrincipal() {
        return isPrincipal;
    }

    public void setPrincipal(boolean isPrincipal) {
        this.isPrincipal = isPrincipal;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    
    
}
