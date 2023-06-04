package br.unitins.topicos1.converterjpa;

import br.unitins.topicos1.model.Encadernacao;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class EncadernacaoConverter implements AttributeConverter<Encadernacao, Integer>{

    @Override
    public Integer convertToDatabaseColumn(Encadernacao encadernacao){
        return encadernacao == null ? null : encadernacao.getId();
    }

    @Override
    public Encadernacao convertToEntityAttribute(Integer id){
        return Encadernacao.valueOf(id);
    }
}
