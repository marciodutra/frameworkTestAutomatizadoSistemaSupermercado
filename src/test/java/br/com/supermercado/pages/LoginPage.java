package br.com.supermercado.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class LoginPage {

    private final WebDriver driver;

    private final By campoEmail = By.cssSelector("input[placeholder='Email']");

    private final By campoSenha = By.cssSelector("input[placeholder='Senha']");

    private final By botaoEntrar = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void informarEmail(String email) {
        driver.findElement(campoEmail).sendKeys(email);
    }

    public void informarSenha(String senha) {
        driver.findElement(campoSenha).sendKeys(senha);
    }

    public void clicarEntrar() {
        driver.findElement(botaoEntrar).click();
    }

    public void login(String email, String senha) {
        informarEmail(email);
        informarSenha(senha);
        clicarEntrar();
    }

}