package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AddNewTasksPage extends BasePage{
    public AddNewTasksPage(WebDriver navegador) {
        super(navegador);
    }


    public String adicionarNovaTarefa(){
        navegador.findElement(By.xpath("//input[@name='title']")).sendKeys("Teste");
        navegador.findElement(By.xpath("//input[@name='date']")).sendKeys("12/12/2022");
        //navegador.findElement(By.className("btn-flat picker__today waves-effect")).click();
        //navegador.findElement(By.className("btn-flat picker__close waves-effect")).click();
        navegador.findElement(By.xpath("//button[text()='OK']")).click();
        navegador.findElement(By.xpath("//input[@name='text']")).sendKeys("Teste 12345 teste teste teste");
        navegador.findElement(By.linkText("Save")).sendKeys("Teste");

        return navegador.findElement(By.id("toast-container")).getText();
    }
}
