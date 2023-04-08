package br.unitins.topicos1.converterjpa;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.unitins.topicos1.model.TamanhoPoster;

@Converter(autoApply = true)
public class TamanhoPosterConverter implements AttributeConverter<TamanhoPoster, Integer>{

    @Override
    public Integer convertToDatabaseColumn(TamanhoPoster tamanhoPoster){
        return tamanhoPoster == null ? null : tamanhoPoster.getId();
    }

    @Override
    public TamanhoPoster convertToEntityAttribute(Integer id){
        return TamanhoPoster.valueOf(id);
    }
    
}
