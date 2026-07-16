package br.com.supermercado.tests.api;

import br.com.supermercado.api.ServiceFactory;
import br.com.supermercado.api.models.Dashboard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import br.com.supermercado.tests.report.listener.ReportExtension;
import org.junit.jupiter.api.extension.ExtendWith;


@ExtendWith(ReportExtension.class)
public class DashboardApiTest extends BaseApiTest {


    @Epic("Supermercado API")
    @Feature("Dashboard")
    @Story("Consultar resumo do dashboard")
    @Test
    void deveConsultarDashboardComSucesso() {


        Dashboard dashboard = ServiceFactory
                .dashboardService()
                .consultarResumo(token);


        assertNotNull(
                dashboard,
                "O dashboard não deve ser nulo"
        );


        assertNotNull(
                dashboard.getQuantidade_vendas(),
                "A quantidade de vendas não deve ser nula"
        );


        assertNotNull(
                dashboard.getProdutos_mais_vendidos(),
                "A lista de produtos mais vendidos não deve ser nula"
        );


        assertFalse(
                dashboard.getProdutos_mais_vendidos().isEmpty(),
                "A lista de produtos mais vendidos não deve estar vazia"
        );


        assertNotNull(
                dashboard.getCaixa_aberto(),
                "O caixa aberto não deve ser nulo"
        );


        assertNotNull(
                dashboard.getCaixa_aberto().getStatus(),
                "O status do caixa não deve ser nulo"
        );


        System.out.println(
                "Quantidade de vendas: "
                        + dashboard.getQuantidade_vendas()
        );


        System.out.println(
                "Produto mais vendido: "
                        + dashboard.getProdutos_mais_vendidos()
                        .get(0)
                        .getNome()
        );


        System.out.println(
                "Status caixa: "
                        + dashboard.getCaixa_aberto()
                        .getStatus()
        );

    }

}