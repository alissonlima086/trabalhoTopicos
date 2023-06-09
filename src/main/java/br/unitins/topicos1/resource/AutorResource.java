package br.unitins.topicos1.resource;

import java.util.List;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolationException;
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

import br.unitins.topicos1.application.Result;
import br.unitins.topicos1.dto.AutorDTO;
import br.unitins.topicos1.dto.AutorResponseDTO;
import br.unitins.topicos1.service.AutorService;

@Path("/autores")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AutorResource {

    @Inject
    AutorService autorService;

    @GET
    @RolesAllowed({"Admin","User", "UserIncompleto"})
    public List<AutorResponseDTO> getAll(){
        return autorService.getAll();
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({"Admin", "User", "UserIncompleto"})
    public AutorResponseDTO findById(@PathParam("id") Long id){
        return autorService.findById(id);
    }

    @POST
    @RolesAllowed({"Admin"})
    public Response insert(AutorDTO dto){
        try{
            AutorResponseDTO autor = autorService.create(dto);
            return Response.status(Status.CREATED).entity(autor).build();
        } catch(ConstraintViolationException e){
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @PUT
    @Path("/{id}/update")
    @RolesAllowed({"Admin"})
    public Response update(@PathParam("id") Long id, AutorDTO dto){
        try{
            AutorResponseDTO autor = autorService.update(id, dto);
            return Response.ok(autor).build();
        } catch(ConstraintViolationException e){
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @DELETE
    @Path("/{id}/delete")
    @RolesAllowed({"Admin"})
    public Response delete(@PathParam("id") Long id){
        autorService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @GET
    @Path("/count")
    @RolesAllowed({"Admin", "User"})
    public Long count(){
        return autorService.count();
    }

    @GET
    @Path("/search/{nome}")
    @RolesAllowed({"Admin", "User"})
    public List<AutorResponseDTO> search(@PathParam("nome") String nome){
        return autorService.findByNome(nome);
    }

}