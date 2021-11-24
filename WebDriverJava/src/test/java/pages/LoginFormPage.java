package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormPage {
    private WebDriver navegador;

    public LoginFormPage(WebDriver navegador){
        this.navegador = navegador;
    }

    public LoginFormPage inserirUser(String user, String senha){
        navegador.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys(user);
        navegador.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys(senha);

        return this;
    }
}
