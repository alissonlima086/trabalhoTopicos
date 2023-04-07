package br.unitins.topicos1.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.unitins.topicos1.model.Poster;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class PosterRepository implements PanacheRepository<Poster>{
    
    public List<Poster> findByNome(String nome){
        if(nome == null){
            return null;
        }

        return find("UPPER(nome) LIKE ?1 ", "%"+nome.toUpperCase()+"%").list();
    }
    
}
