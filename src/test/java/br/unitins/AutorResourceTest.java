package br.unitins;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.AutorDTO;
import br.unitins.topicos1.dto.AutorResponseDTO;
import br.unitins.topicos1.resource.AutorResource;
import br.unitins.topicos1.service.AutorService;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

@QuarkusTest
public class AutorResourceTest {

    @Inject
    AutorService autorService;

    @Test
    public void getAllTest() {
        given()
          .when().get("/autores")
          .then()
             .statusCode(200);
    }
    
    @Test
    public void testInsert() {
        AutorDTO autorDTO = new AutorDTO(
            7,
            "Joao dos tals",
            "73783993003",
            "Fulano que escreve"
        );


        given()
          .contentType(ContentType.JSON)
          .body(autorDTO)
          .when().post("/autores")
          .then()
             .statusCode(201)
             .body("id", notNullValue(),
              	 "nome", is("Joao dos tals"),
             	 "cpf", is("333.333.333-33"),
                 "bio", is("Fulano que escreve"));
    }
    
}
