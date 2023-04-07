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

import br.unitins.topicos1.model.Ilustrador;
import br.unitins.topicos1.repository.IlustradorRepository;

@Path("/ilustradores")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class IlustradorResource {

    @Inject
    private IlustradorRepository repository;

    @GET
    public List<Ilustrador> getAll(){

        return repository.findAll().list();

    }

    @POST
    @Transactional
    public Ilustrador insert(Ilustrador ilustrador){

        repository.persist(ilustrador);

        return ilustrador;

    }

    @PUT
    @Path("`{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Ilustrador update(@PathParam("id") Long id, Ilustrador ilustrador){
        
        Ilustrador entity = repository.findById(id);

        entity.setNome(ilustrador.getNome());
        entity.setBio(ilustrador.getBio());

        return entity;
    }

    @GET
    @Path("search/{nome}")
    public List<Ilustrador> search(@PathParam("nome") String nome){
        return repository.findByNome(nome);
    }
}

