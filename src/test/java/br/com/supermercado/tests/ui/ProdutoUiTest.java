package br.com.supermercado.tests.ui;

import br.com.supermercado.config.Config;
import br.com.supermercado.pages.LoginPage;
import br.com.supermercado.pages.ProdutoPage;
import br.com.supermercado.tests.base.BaseUiTest;
import br.com.supermercado.tests.report.listener.ReportExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import br.com.supermercado.pages.MenuPage;
import br.com.supermercado.pages.DashboardPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(ReportExtension.class)
public class ProdutoUiTest extends BaseUiTest {


    @Test
    void deveAcessarTelaDeProdutos() {


        driver.get(Config.getBaseUrl());


        LoginPage loginPage =
                new LoginPage(driver);


        loginPage.login(
                Config.getLoginEmail(),
                Config.getLoginSenha()
        );


        DashboardPage dashboardPage =
                new DashboardPage(driver);


        assertTrue(
                dashboardPage.estaAberto(),
                "Dashboard não abriu após login."
        );


        MenuPage menuPage =
                new MenuPage(driver);


        menuPage.acessarProdutos();


        ProdutoPage produtoPage =
                new ProdutoPage(driver);


        assertTrue(
                produtoPage.estaAberto(),
                "Tela de produtos não abriu."
        );

    }

}