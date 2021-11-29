package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginFormPage extends BasePage  {

    public LoginFormPage(WebDriver navegador) {
        super(navegador);
    }

    public SecretaPage fazerLogin(String user, String senha){
        navegador.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys(user);
        navegador.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys(senha);

        //Clicar no botão: "Sign in" do texto: "SIGN IN"
        navegador.findElement(By.id("signinbox")).findElement(By.linkText("SIGN IN")).click();

        return new SecretaPage(navegador);
    }
}
