package br.com.supermercado.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MenuPage {

    private final WebDriver driver;


    private final By menuProdutos =
            By.cssSelector("a[href='/produtos']");


    public MenuPage(WebDriver driver) {
        this.driver = driver;
    }


    public void acessarProdutos() {

        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(20)
        );

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(menuProdutos)
        ).click();

    }

}