package br.com.supermercado.api.services;

import br.com.supermercado.api.models.Produto;
import br.com.supermercado.config.Config;

import static io.restassured.RestAssured.given;

import java.util.Arrays;
import java.util.List;

public class ProdutoService {

    public List<Produto> listarProdutos(String token){

        Produto[] produtos =

                given()
                        .baseUri(Config.getApiUrl())
                        .header("Authorization", "Bearer " + token)

                        .when()
                        .get("/produtos")

                        .then()
                        .statusCode(200)
                        .extract()
                        .as(Produto[].class);

        return Arrays.asList(produtos);
    }

    public Produto cadastrarProduto(Produto produto, String token) {

        return given()

                .baseUri(Config.getApiUrl())

                .header("Authorization", "Bearer " + token)

                .contentType("application/json")

                .body(produto)

                .when()

                .post("/produtos")

                .then()

                .statusCode(201)

                .extract()

                .as(Produto.class);
    }

    public Produto atualizarProduto(int id, Produto produto, String token) {

        return given()

                .baseUri(Config.getApiUrl())

                .header("Authorization", "Bearer " + token)

                .contentType("application/json")

                .body(produto)

                .when()

                .put("/produtos/" + id)

                .then()

                .statusCode(200)

                .extract()

                .as(Produto.class);
    }

}