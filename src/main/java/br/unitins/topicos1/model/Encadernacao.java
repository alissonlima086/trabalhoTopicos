package br.unitins.topicos1.model;

public enum Encadernacao{
    CAPA_DURA(1, "Capa Dura"), CAPA_COMUM(2, "Capa Comum");

    private int id;
    private String label;

    Encadernacao(int id, String label){
        this.id = id;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static Encadernacao valueOf(Integer id) throws IllegalArgumentException{
        if(id == null){
            return null;
        }
        for(Encadernacao encadernacao : Encadernacao.values()){
            if(id.equals(encadernacao.getId())){
                return encadernacao;
            }
        }

        throw new IllegalArgumentException("id invalido: "+ id);
    }
}