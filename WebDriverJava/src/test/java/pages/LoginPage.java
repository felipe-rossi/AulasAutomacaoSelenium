package pages;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import suport.Web;

public class LoginPage {
    private WebDriver navegador;

   //Criando o construtor
   public LoginPage(WebDriver navegador){
       this.navegador = navegador;
   }

    public LoginFormPage clicarSignIn(){

        //Clicar no link de nome: "Sign in"
        navegador.findElement(By.linkText("Sign in")).click();

        return new LoginFormPage(navegador);
    }
}
