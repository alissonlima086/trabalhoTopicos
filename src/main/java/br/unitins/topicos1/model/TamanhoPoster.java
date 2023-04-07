package br.unitins.topicos1.model;

public enum TamanhoPoster{
    A1(1, "A1"), A2(2, "A2"), A3(3, "A3");

    private int id;
    private String label;

    TamanhoPoster(int id, String label){
        this.id = id;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static TamanhoPoster valueOf(Integer id) throws IllegalArgumentException{
        if(id == null){
            return null;
        }
        for(TamanhoPoster tamanhoPoster : TamanhoPoster.values()){
            if(id.equals(tamanhoPoster.getId())){
                return tamanhoPoster;
            }
        }

        throw new IllegalArgumentException();
    }
}