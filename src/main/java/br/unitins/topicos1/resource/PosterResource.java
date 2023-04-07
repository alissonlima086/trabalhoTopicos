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

import br.unitins.topicos1.model.Poster;
import br.unitins.topicos1.repository.PosterRepository;

@Path("/autores")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PosterResource {

    @Inject
    private PosterRepository repository;

    @GET
    public List<Poster> getAll(){

        return repository.findAll().list();

    }

    @POST
    @Transactional
    public Poster insert(Poster poster){

        repository.persist(poster);

        return poster;
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Poster update(@PathParam("id") Long id, Poster poster){
        
        Poster entity = repository.findById(id);

        entity.setNome(poster.getNome());
        entity.setPreco(poster.getPreco());
        entity.setTamanhoPoster(poster.getTamanhoPoster());
        entity.setEstoque(poster.getEstoque());
        entity.setDescicao(poster.getDescicao());

        return entity;
    }

    @GET
    @Path("/search/{nome}")
    public List<Poster> search(@PathParam("nome") String nome){
        return repository.findByNome(nome);
    }
    
}
