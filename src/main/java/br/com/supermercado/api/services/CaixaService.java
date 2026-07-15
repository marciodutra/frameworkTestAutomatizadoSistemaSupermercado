package br.com.supermercado.api.services;

import br.com.supermercado.api.models.Caixa;
import br.com.supermercado.config.Config;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class CaixaService {

    public Caixa consultarCaixaAtual(String token) {

        return given()

                .baseUri(Config.getApiUrl())

                .header("Authorization", "Bearer " + token)

                .when()

                .get("/caixa/atual")

                .then()

                .statusCode(200)

                .extract()

                .as(Caixa.class);
    }

    public Caixa abrirCaixa(double valorAbertura, String token) {

        Map<String, Object> body = new HashMap<>();
        body.put("valor_abertura", valorAbertura);

        return given()

                .baseUri(Config.getApiUrl())

                .header("Authorization", "Bearer " + token)

                .contentType("application/json")

                .body(body)

                .when()

                .post("/caixa/abrir")

                .then()

                .statusCode(200)

                .extract()

                .as(Caixa.class);
    }
}