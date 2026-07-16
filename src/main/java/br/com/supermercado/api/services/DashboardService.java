package br.com.supermercado.api.services;

import br.com.supermercado.api.models.Dashboard;
import br.com.supermercado.config.Config;

import static io.restassured.RestAssured.given;

public class DashboardService {


    public Dashboard consultarResumo(String token) {

        return given()

                .baseUri(Config.getApiUrl())

                .header(
                        "Authorization",
                        "Bearer " + token
                )

                .when()

                .get("/dashboard/resumo")

                .then()

                .statusCode(200)

                .extract()

                .as(Dashboard.class);

    }

}