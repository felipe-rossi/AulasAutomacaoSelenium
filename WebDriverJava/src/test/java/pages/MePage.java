package pages;

import net.bytebuddy.asm.Advice;
import org.apache.commons.lang.ArrayUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;

import javax.swing.*;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class MePage extends BasePage {

    public MePage(WebDriver navegador) {
        super(navegador);
    }

    public MePage clicarMoreData(){

        //Clicar no link com o texto: "MORE DATA ABOUT YOU"
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();

        return this;
    }

    public MoreDataAboutYou clicarNoBotaoAddMoreData(){
        //Clicar no botão atraves do seu Xpath:"//button[@data-target=\"addmoredata""));
        navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();

        return new MoreDataAboutYou(navegador);
    }

    public String removerContato(String contato){

        WebElement numeroTelefone = navegador.findElement(By.xpath("//span[text()='" + contato +  "']"));

        ((JavascriptExecutor) navegador).executeScript("arguments[0].scrollIntoView(true);", numeroTelefone);

        navegador.findElement(By.xpath("//span[text() = '" + contato +  "']//following::a")).click();

        navegador.switchTo().alert().accept();

        return navegador.findElement(By.id("toast-container")).getText();
    }

    public MePage mudarNome(){
        String nomes[] = {"Carlos", "Felipe", "Caio", "Gabriel", "Julio", "Maria"};
        Random rd = new Random();
        String novoNome = "";

        String nome = navegador.findElement(By.xpath("//input[@name='name']")).getAttribute("value");
        WebElement inputNome = navegador.findElement(By.xpath("//input[@name='name']"));

        int indiceVetor = ArrayUtils.indexOf(nomes,nome);

        if (nomes[indiceVetor].equals(nome)){
            novoNome = nomes[rd.nextInt(6)];

            while(novoNome.equals(nome)){
                novoNome = nomes[rd.nextInt(6)];
            }
        }

        inputNome.clear();
        inputNome.sendKeys(novoNome);

        navegador.findElement(By.id("changeAboutYou")).click();

        String mensagemExibidaTela = navegador.findElement(By.id("toast-container")).getText();

        assertEquals("Now you will be called " + novoNome + "!" , mensagemExibidaTela);

        return this;
    }
}
