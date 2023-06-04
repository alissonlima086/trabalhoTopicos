package br.unitins.topicos1.resource;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

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

