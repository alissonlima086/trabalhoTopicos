package br.unitins.topicos1.resource;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.unitins.topicos1.model.Autor;
import br.unitins.topicos1.repository.AutorRepository;

@Path("/autores")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AutorResource {

    @Inject
    private AutorRepository repository;

    @GET
    public List<Autor> getAll(){

        return repository.findAll().list();
        
    }

    @POST
    @Transactional
    public Autor insert(Autor autor){

        repository.persist(autor);

        return autor;
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Autor update(@PathParam("id") Long id, Autor autor){

        Autor entity = repository.findById(id);

        entity.setNome(autor.getNome());
        entity.setBio(autor.getBio());

        return entity;
    }

    @GET
    @Path("/search/{nome}")
    public List<Autor> search(@PathParam("nome") String nome){
        return repository.findByNome(nome);
    }

}
