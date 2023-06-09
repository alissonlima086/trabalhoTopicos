package br.unitins.topicos1.resource;

import java.util.List;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
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
import br.unitins.topicos1.dto.ListaDesejoDTO;
import br.unitins.topicos1.dto.ListaDesejoResponseDTO;
import br.unitins.topicos1.dto.UsuarioDTO;
import br.unitins.topicos1.dto.UsuarioResponseDTO;
import br.unitins.topicos1.service.UsuarioService;

@Path("/usuarios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioResource {
    
    @Inject
    UsuarioService usuarioService;

    @GET
    @RolesAllowed({"Admin"})
    public List<UsuarioResponseDTO> getAll() {
        return usuarioService.getAll();
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({"Admin"})
    public UsuarioResponseDTO findById(@PathParam("id") Long id) {
        return usuarioService.findById(id);
    }

    @POST
    @RolesAllowed({"Admin"})
    public Response insert(UsuarioDTO dto) {
        try {
            UsuarioResponseDTO Usuario = usuarioService.create(dto);
            return Response.status(Status.CREATED).entity(Usuario).build();
        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed({"Admin"})
    public Response update(@PathParam("id") Long id, UsuarioDTO dto) {
        try {
            UsuarioResponseDTO usuario = usuarioService.update(id, dto);
            return Response.ok(usuario).status(Status.NO_CONTENT).build();
        } catch (ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed({"Admin"})
    public Response delete(@PathParam("id") Long id) {
        usuarioService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }


    @GET
    @Path("/count")
    @RolesAllowed({"Admin"})
    public long count(){
        return usuarioService.count();
    }

    @GET
    @Path("/search/{nome}")
    @RolesAllowed({"Admin"})
    public List<UsuarioResponseDTO> search(@PathParam("nome") String nome){
        return usuarioService.findByNome(nome);
        
    }

    @GET
    @Path("/listadesejo/{idUsuario}")
    @RolesAllowed({"Admin"})
    public ListaDesejoResponseDTO getListaDesejo(@PathParam("idUsuario") Long idUsuario) {

        return usuarioService.getListaDesejo(idUsuario);
    }

    @POST
    @Path("/listadesejo")
    @Transactional
    @RolesAllowed({"Admin"})
    public Response insertListaDesejo(ListaDesejoDTO listaDto) {

        try {

            usuarioService.insertListaDesejo(listaDto);

            return Response
                    .status(Status.CREATED)
                    .build();
        } catch (ConstraintViolationException e) {

            Result result = new Result(e.getConstraintViolations());

            return Response
                    .status(Status.NOT_FOUND)
                    .entity(result)
                    .build();
        }
    }
}

