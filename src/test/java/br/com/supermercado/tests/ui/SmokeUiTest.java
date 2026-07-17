package br.com.supermercado.tests.ui;

import br.com.supermercado.config.Config;
import br.com.supermercado.tests.base.BaseUiTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SmokeUiTest extends BaseUiTest {

    @Test
    void deveAbrirAplicacao() {

        driver.get(Config.getBaseUrl());

        assertTrue(driver.getCurrentUrl().contains("supermercado-react.vercel.app"));
    }
}