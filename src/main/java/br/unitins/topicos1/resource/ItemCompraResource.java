package br.unitins.topicos1.resource;

import java.util.List;

import org.eclipse.microprofile.jwt.JsonWebToken;

import br.unitins.topicos1.dto.ItemCompraResponseDTO;
import br.unitins.topicos1.dto.UsuarioResponseDTO;
import br.unitins.topicos1.service.ItemCompraService;
import br.unitins.topicos1.service.UsuarioServiceImpl;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/itemCompra")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ItemCompraResource {

    @Inject
    ItemCompraService itemCompraSevice;

    @Inject
    JsonWebToken jwt;

    @Inject
    UsuarioServiceImpl usuarioService;
    
    @GET
    @RolesAllowed({"Admin", "User"})
    public List<ItemCompraResponseDTO> getAll() {
        return itemCompraSevice.getAll();
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({"Admin", "User"})
    public ItemCompraResponseDTO findById(@PathParam("id") Long id) {
        return itemCompraSevice.findById(id);
    }

    @GET
    @Path("/count")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({"Admin", "User"})
    public long count() {

        String login = jwt.getSubject();

        UsuarioResponseDTO usuario = usuarioService.findByLogin(login);

        return itemCompraSevice.countItemCompra(usuario.id());
    }

    @GET
    @Path("/count2")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({"Admin", "User"})
    public long count2(){
        return itemCompraSevice.count();
    }

}
