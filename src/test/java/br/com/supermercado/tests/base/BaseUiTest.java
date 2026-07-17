package br.com.supermercado.tests.base;

import br.com.supermercado.tests.ui.driver.DriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public abstract class BaseUiTest {

    protected WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = DriverManager.getDriver();
    }

    @AfterEach
    void tearDown() {
        DriverManager.quitDriver();
    }
}