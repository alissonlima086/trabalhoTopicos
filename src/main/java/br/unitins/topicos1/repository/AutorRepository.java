package br.unitins.topicos1.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.unitins.topicos1.model.Autor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class AutorRepository implements PanacheRepository<Autor>{

    public List<Autor> findByNome(String nome){
        if(nome == null){
            return null;
        }

        return find("UPPER(nome) LIKE ?1 ", "%"+nome.toUpperCase()+"%").list();
    }
    
}
