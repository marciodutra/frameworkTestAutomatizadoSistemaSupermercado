package br.com.supermercado.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {

    private final WebDriver driver;

    private final By tituloDashboard =
            By.xpath("//h1[contains(text(),'Dashboard')]");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean estaAberto() {

        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(20)
        );

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(tituloDashboard)
        );

        return true;

    }

}