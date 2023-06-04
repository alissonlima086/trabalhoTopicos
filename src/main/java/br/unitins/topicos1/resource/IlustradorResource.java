package br.unitins.topicos1.resource;

import java.util.List;

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
import br.unitins.topicos1.dto.IlustradorDTO;
import br.unitins.topicos1.dto.IlustradorResponseDTO;
import br.unitins.topicos1.service.IlustradorService;

@Path("/ilustradores")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class IlustradorResource {

    @Inject
    IlustradorService ilustradorService;

    @GET
    public List<IlustradorResponseDTO> getAll(){
        return ilustradorService.getAll();
    }

    @GET
    @Path("/{id}")
    public IlustradorResponseDTO findById(@PathParam("id") Long id){
        return ilustradorService.findById(id);
    }

    @POST
    public Response insert(IlustradorDTO dto){
        try{
            IlustradorResponseDTO ilustrador = ilustradorService.create(dto);
            return Response.status(Status.CREATED).entity(ilustrador).build();
        } catch(ConstraintViolationException e){
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @PUT
    @Path("/{id}/update")
    public Response update(@PathParam("id") Long id, IlustradorDTO dto){
        try{
            IlustradorResponseDTO ilustrador = ilustradorService.update(id, dto);
            return Response.ok(ilustrador).build();
        } catch(ConstraintViolationException e){
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @DELETE
    @Path("/{id}/delete")
    public Response delete(@PathParam("id") Long id){
        ilustradorService.delete(id);
        return Response.status((Status.NO_CONTENT)).build();
    }

    @GET
    @Path("/count")
    public Long count(){
        return ilustradorService.count();
    }

    @GET
    @Path("search/{nome}")
    public List<IlustradorResponseDTO> search(@PathParam("nome") String nome){
        return ilustradorService.findByNome(nome);
    }
}

