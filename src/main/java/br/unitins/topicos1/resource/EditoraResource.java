package br.unitins.topicos1.resource;

import java.util.List;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import br.unitins.topicos1.dto.EditoraDTO;
import br.unitins.topicos1.model.Editora;
import br.unitins.topicos1.repository.EditoraRepository;
import br.unitins.topicos1.service.EditoraService;

@Path("/editoras")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EditoraResource {
    
    @Inject
    private EditoraRepository repository;

    @Inject EditoraService editoraService;

    @GET
    @RolesAllowed({"Admin", "User", "UserIncompleto"})
    public List<Editora> getAll() {
        
         return repository.findAll().list();

    }

    @POST
    @Transactional
    @RolesAllowed({"Admin"})
    public Editora insert(EditoraDTO editora) {

        Editora entity = new Editora(); 

        entity.setNome(editora.nome());
        repository.persist(entity);

        return entity;
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed({"Admin"})
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Editora update(@PathParam("id") Long id, EditoraDTO editora) {

         Editora entity = repository.findById(id);

         entity.setNome(editora.nome());

        return entity;
    }

    @DELETE
    @Path("/{id}/delete")
    @RolesAllowed({"Admin"})
    public Response delete(@PathParam("id") Long id){
        editoraService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @GET
    @Path("/count")
    @RolesAllowed({"Admin", "User"})

    public long count(){
        return repository.count();
    }

    @GET
    @Path("/search/{nome}")
    @RolesAllowed({"Admin", "User", "UserIncompleto"})
    public List<Editora> search(@PathParam("nome") String nome){
        return repository.findByNome(nome);
    }
}
