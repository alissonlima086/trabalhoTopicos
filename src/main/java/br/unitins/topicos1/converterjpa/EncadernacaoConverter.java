package br.unitins.topicos1.converterjpa;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.unitins.topicos1.model.Encadernacao;

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
