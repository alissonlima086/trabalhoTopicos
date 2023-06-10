package br.unitins;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

import br.unitins.topicos1.repository.AutorRepository;

import br.unitins.topicos1.service.AutorService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;

@QuarkusTest
public class AutorResourceTest {

    @Inject
    AutorService autorService;

    @Inject
    AutorRepository autorRepository;

    
    @Test
    @RolesAllowed({"Admin","User", "UserIncompleto"})
    public void testGetAllAutores(){
        given().when().get("/autores").then().statusCode(200);
    }
}