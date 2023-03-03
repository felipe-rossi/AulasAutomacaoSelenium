package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyTasksPage extends BasePage{
    public MyTasksPage(WebDriver navegador) {
        super(navegador);
    }

    public String validarEtapaMyTasks(){
        WebDriverWait wdw = new WebDriverWait(navegador, Duration.ofSeconds(10));
        wdw.until(ExpectedConditions.visibilityOf(navegador.findElement(By.xpath("//h5[text()='My tasks']"))));

        WebElement texto = navegador.findElement(By.xpath("//h5[text()='My tasks']"));
        return navegador.findElement(By.xpath("//h5[text()='My tasks']")).getText();
    }

    public AddNewTasksPage acessarNovaTarefa(){
        navegador.findElement(By.xpath("//button[@data-target='addtask']")).click();
        return new AddNewTasksPage(navegador);
    }
}
