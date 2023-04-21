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

import br.unitins.topicos1.dto.EditoraDTO;
import br.unitins.topicos1.model.Editora;
import br.unitins.topicos1.repository.EditoraRepository;

@Path("/editoras")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EditoraResource {
    
    @Inject
    private EditoraRepository repository;

    @GET
    public List<Editora> getAll() {
        
         return repository.findAll().list();

    }

    @POST
    @Transactional
    public Editora insert(EditoraDTO editora) {

        Editora entity = new Editora(); 

        entity.setNome(editora.nome());
        repository.persist(entity);

        return entity;
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Editora update(@PathParam("id") Long id, EditoraDTO editora) {

         Editora entity = repository.findById(id);

         entity.setNome(editora.nome());

        return entity;
    }

    @GET
    @Path("/count")
    public long count(){
        return repository.count();
    }

    @GET
    @Path("/search/{nome}")
    public List<Editora> search(@PathParam("nome") String nome){
        return repository.findByNome(nome);
    }
}

